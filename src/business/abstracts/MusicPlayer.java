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
		
		repeatStateProperty.set(RepeatState.NONE);
		shuffleStateProperty.set(ShuffleState.INACTIVE);
		playingStateProperty.set(PlayingState.PAUSE);
		
		currentPlaytimeProperty.set(0);
	}
	
	public RepeatState getRepeatState() {
		return repeatStateProperty.get();
	}
	
	public ShuffleState getShuffleState() {
		return shuffleStateProperty.get();
	}
	
	public PlayingState getPlayingState() {
		return playingStateProperty.get();
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