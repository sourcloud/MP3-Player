package business.services;

import business.abstracts.MusicPlayer;
import business.data.Playlist;
import business.data.Track;
import business.services.util.MathUtil;
import business.services.util.SkipState;

public class MP3Player extends MusicPlayer {
	
	private Playlist tracklist; 
	
	private Thread playingThread;
	private Thread positionThread;

	public MP3Player() {
		super();
		
		playingThread = new Thread(() -> {
			
			while (!Thread.currentThread().isInterrupted()) {
				
				while (playingStateProperty.get().playing())
					audioPlayer.play();	
		
			}
			
		});
		
		positionThread = new Thread(() -> {
			
			while (!Thread.currentThread().isInterrupted()) {
			
				if (audioPlayer != null) {
					
					if (tracklist.current().getLength() - audioPlayer.position() < 100)
						skip();
					
					currentPlaytimeProperty.set(audioPlayer.position());	
				}
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
			}
			
		});
		
		playingThread.setDaemon(true);
		positionThread.setDaemon(true);
		
		playingThread.start();
		positionThread.start();
		
	}
	
	@Override
	public Playlist getPlaylist() {
		return tracklist;
	}
	
	@Override
	public void setPlaylist(Playlist tracklist) {
		this.tracklist = tracklist;
		activePlaylistProperty.set(tracklist);
	}
	
	@Override
	public void play() {
		
		if (audioPlayer != null && !playingStateProperty.get().playing()) {	
			switchPlayingState();
	
		} else if (tracklist != null) {
			Track currentTrack = tracklist.current();
			play(currentTrack);
		}
	}

	@Override
	public void play(String pathToFile) {
		
		if (playingStateProperty.get().playing())
			stop();

		audioPlayer = minim.loadMP3File(pathToFile);
		activeTrackProperty.set(new Track(pathToFile));
		
		play();
	}
	
	@Override
	public void play(Track toPlay) {
		final String path = toPlay.getPath();
		play(path);
	}

	@Override
	public void pause() {
		if (audioPlayer != null && playingStateProperty.get().playing()) {
			switchPlayingState();
			audioPlayer.pause();
		}
	}

	@Override
	public void stop() {
		if (audioPlayer != null) {
			pause();
			audioPlayer.rewind();
		}
	}

	@Override
	public void volume(float linearValue) {
		if (audioPlayer != null) {
			final float dbValue = MathUtil.convertLinearToDB(linearValue);
			audioPlayer.setGain(dbValue);
		}
	}
	
	public void skipTo(int milliseconds) {
		
		if (audioPlayer != null) {
			
			if (playingStateProperty.get().playing())
				stop();
			else
				audioPlayer.rewind();
			
			audioPlayer.skip(milliseconds);
			play();
		}
		
		
	}

	@Override
	public void skip() {
	
		if (tracklist != null) 
			skipStateProperty.get().skip(this);
			
	}

	@Override
	public void skipBack() {
		
		if (tracklist != null)
			skipStateProperty.get().skipBack(this);
		
	}
	
	@Override
	public void toggleRepeat() {
		
		SkipState current, next;
		
		current = skipStateProperty.get();
		
		switch(current) {
		
			case SINGLE:
				next = SkipState.DEFAULT;
				break;
				
			case ALL:
				next = SkipState.SINGLE;
				break;
				
			case DEFAULT: // FALLTHROUGH
				
			case SHUFFLE: // FALLTHROUGH
				
			default:
				next = SkipState.ALL;
				break;
		}
		
		skipStateProperty.set(next);
		
	}
	
	@Override
	public void toggleShuffle() {
		skipStateProperty.set(SkipState.SHUFFLE);
	}

	
	private void switchPlayingState() {
		playingStateProperty.set(playingStateProperty.get().switchState());
	}
	
}
