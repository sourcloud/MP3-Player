package business.services;

import business.abstracts.MusicPlayer;
import business.data.Playlist;
import business.data.Track;
import business.services.util.MathUtil;
import javafx.application.Platform;

public class MP3Player extends MusicPlayer {
	
	private Playlist tracklist; 
	
	private Thread playingThread;
	private Thread positionThread;

	public MP3Player() {
		super();
		
		playingThread = new Thread(() -> {
			
			while (!Thread.currentThread().isInterrupted()) {
				
				while (playingState.playing())
					audioPlayer.play();	
				
			}
			
		});
		
		positionThread = new Thread(() -> {
			
			while (!Thread.currentThread().isInterrupted()) {
			
				if (audioPlayer != null) {
					
					if (tracklist.current().getLength() - audioPlayer.position() < 100)
						skip();
					
					Platform.runLater(() -> currentPlaytimeProperty.set(audioPlayer.position()));
					
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
		Platform.runLater(() -> activePlaylistProperty.set(tracklist));
	}
	
	@Override
	public void play() {
		
		if (audioPlayer != null && !playingState.playing()) {	
			switchPlayingState();
	
		} else if (tracklist != null) {
			Track currentTrack = tracklist.current();
			play(currentTrack);
		}
	}

	@Override
	public void play(String pathToFile) {
		
		if (playingState.playing())
			stop();

		audioPlayer = minim.loadMP3File(pathToFile);
		Platform.runLater(() -> activeTrackProperty.set(new Track(pathToFile)));
		
		play();
	}
	
	@Override
	public void play(Track toPlay) {
		final String path = toPlay.getPath();
		play(path);
	}

	@Override
	public void pause() {
		if (audioPlayer != null && playingState.playing()) {
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
			
			if (playingState.playing())
				stop();
			
			audioPlayer.skip(milliseconds);
			play();
		}
		
		
	}

	@Override
	public void skip() {
		
		if (tracklist != null) {
			
			if (repeatState.repeatOne())
				play(tracklist.current());
			
			else if (shuffleState.active())
				play(tracklist.random());
			
			else if (repeatState.repeatAll() || tracklist.hasNext())
				play(tracklist.next());
			
		}
	}

	@Override
	public void skipBack() {
		
		if (tracklist != null) {
			
			if (repeatState.repeatOne())
				play(tracklist.current());
			
			else if (repeatState.repeatAll() || tracklist.hasPrev())
				play(tracklist.prev());
			
		}
	}

	@Override
	public void toggleShuffle() {
		shuffleState = shuffleState.switchState();
		Platform.runLater(() -> shuffleStateProperty.set(shuffleState));
	}

	@Override
	public void toggleRepeat() {
		repeatState = repeatState.nextState();
		Platform.runLater(() -> repeatStateProperty.set(repeatState));
	}
	
	private void switchPlayingState() {
		playingState = playingState.switchState();
		Platform.runLater(() -> playingStateProperty.set(playingState));
	}

}
