package business.services;

import business.abstracts.MusicPlayer;
import business.data.Playlist;
import business.data.Track;
import business.services.util.MathUtil;
import business.services.util.PlayingState;

public class MP3Player extends MusicPlayer {
	
	private Playlist tracklist; 

	public MP3Player() {
		super();
	}
	
	@Override
	public void setPlaylist(Playlist tracklist) {
		this.tracklist = tracklist;
	}
	
	@Override
	public void play() {
		if (audioPlayer != null) {
			audioPlayer.play();
			playingState = PlayingState.PLAY;
		} else if (tracklist != null) {
			Track currentTrack = tracklist.current();
			play(currentTrack);
		}
	}

	@Override
	public void play(String pathToFile) {
		if (playingState.isPlaying())
			stop();
		audioPlayer = minim.loadMP3File(pathToFile);
		play();
	}
	
	@Override
	public void play(Track toPlay) {
		final String path = toPlay.getPath();
		play(path);
	}

	@Override
	public void pause() {
		if (audioPlayer != null && playingState.isPlaying()) {
			audioPlayer.pause();
			playingState = playingState.switchState();
		}
	}

	@Override
	public void stop() {
		if (audioPlayer != null) {
			audioPlayer.pause();
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
		if (tracklist != null && repeatState.repeatOne())
			play(tracklist.current());
		else if (tracklist != null && shuffleState.isActive())
			play(tracklist.random());
		else if (tracklist != null && (repeatState.repeatAll() || tracklist.hasNext()))
			play(tracklist.next());
	}

	@Override
	public void skipBack() {
		if (tracklist != null && (repeatState.repeatAll() || tracklist.hasPrev()))
			play(tracklist.prev());
	}

	@Override
	public void toggleShuffle() {
		shuffleState = shuffleState.switchState();
	}

	@Override
	public void toggleRepeat() {
		repeatState = repeatState.nextState();
	}

}
