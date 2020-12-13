package business.abstracts;

import business.data.Playlist;
import business.data.Track;
import business.interfaces.MediaPlayer;
import business.services.util.PlayingState;
import business.services.util.RepeatState;
import business.services.util.ShuffleState;
import de.hsrm.mi.eibo.simpleplayer.SimpleAudioPlayer;
import de.hsrm.mi.eibo.simpleplayer.SimpleMinim;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public abstract class MusicPlayer implements MediaPlayer<Track> {

	protected SimpleMinim minim;
	protected SimpleAudioPlayer audioPlayer;

	protected RepeatState repeatState;
	protected ShuffleState shuffleState;
	protected PlayingState playingState;
	
	protected SimpleObjectProperty<RepeatState> repeatStateProperty;
	protected SimpleObjectProperty<ShuffleState> shuffleStateProperty;
	protected SimpleObjectProperty<PlayingState> playingStateProperty;
	protected SimpleObjectProperty<Track> activeTrackProperty;
	protected SimpleObjectProperty<Playlist> activePlaylistProperty;
	
	protected IntegerProperty currentPlaytimeProperty;
	
	public MusicPlayer() {
		
		minim = new SimpleMinim();
		
		repeatStateProperty = new SimpleObjectProperty<>();
		shuffleStateProperty = new SimpleObjectProperty<>();
		playingStateProperty = new SimpleObjectProperty<>();
		activeTrackProperty = new SimpleObjectProperty<>();
		activePlaylistProperty = new SimpleObjectProperty<>();
		
		currentPlaytimeProperty = new SimpleIntegerProperty();
		
		repeatState = RepeatState.NONE;
		shuffleState = ShuffleState.INACTIVE;
		playingState = PlayingState.PAUSE;
		
		repeatStateProperty.set(repeatState);
		shuffleStateProperty.set(shuffleState);
		playingStateProperty.set(playingState);
		
		currentPlaytimeProperty.set(0);
	}
	
	public RepeatState getRepeatState() {
		return repeatState;
	}
	
	public ShuffleState getShuffleState() {
		return shuffleState;
	}
	
	public PlayingState getPlayingState() {
		return playingState;
	}
	
	public SimpleObjectProperty<RepeatState> repeatStateProperty() {
		return repeatStateProperty;
	}
	
	public SimpleObjectProperty<ShuffleState> shuffleStateProperty() {
		return shuffleStateProperty;
	}
	
	public SimpleObjectProperty<PlayingState> playingStateProperty() {
		return playingStateProperty;
	}
	
	public SimpleObjectProperty<Track> activeTrackProperty() {
		return activeTrackProperty;
	}
	
	public SimpleObjectProperty<Playlist> activePlaylistProperty() {
		return activePlaylistProperty;
	}
	
	public IntegerProperty currentPlaytimeProperty() {
		return currentPlaytimeProperty;
	}
	
}