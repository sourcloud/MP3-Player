package business.services;

import business.abstracts.MusicPlayer;
import business.data.Playlist;
import business.data.Track;
import business.services.util.MathUtil;

public class MP3Player extends MusicPlayer {
	
	private Playlist tracklist; 

	public MP3Player() {
		super();
		tracklist = new Playlist();
	}
	
	public Playlist getPlaylist() {
		return tracklist;
	}
	
	@Override
	public void setPlaylist(Playlist tracklist) {
		this.tracklist = tracklist;
	}
	
	@Override
	public void play() {
		
		if (audioPlayer != null) {
			audioPlayer.play();
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
		if (audioPlayer != null && playingState.playing()) {
			audioPlayer.pause();
			switchPlayingState();
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
		shuffleStateProperty.set(shuffleState);
	}

	@Override
	public void toggleRepeat() {
		repeatState = repeatState.nextState();
		repeatStateProperty.set(repeatState);
	}
	
	private void switchPlayingState() {
		playingState = playingState.switchState();
		playingStateProperty.set(playingState);
	}

}
