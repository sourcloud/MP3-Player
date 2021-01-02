package business.abstracts;

import business.data.Playlist;
import business.data.Track;
import business.interfaces.MediaPlayer;
import business.services.util.PlayingState;
import business.services.util.SkipState;
import de.hsrm.mi.eibo.simpleplayer.SimpleAudioPlayer;
import de.hsrm.mi.eibo.simpleplayer.SimpleMinim;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public abstract class MusicPlayer implements MediaPlayer<Track> {

	protected SimpleMinim minim;
	protected SimpleAudioPlayer audioPlayer;
	
	protected SimpleObjectProperty<SkipState> skipStateProperty;
	protected SimpleObjectProperty<PlayingState> playingStateProperty;
	protected SimpleObjectProperty<Track> activeTrackProperty;
	protected SimpleObjectProperty<Playlist> activePlaylistProperty;
	
	protected IntegerProperty currentPlaytimeProperty;
	
	public MusicPlayer() {
		
		minim = new SimpleMinim();
		
		skipStateProperty = new SimpleObjectProperty<>();
		playingStateProperty = new SimpleObjectProperty<>();
		activeTrackProperty = new SimpleObjectProperty<>();
		activePlaylistProperty = new SimpleObjectProperty<>();
		
		currentPlaytimeProperty = new SimpleIntegerProperty();
		
		skipStateProperty.set(SkipState.DEFAULT);
		playingStateProperty.set(PlayingState.PAUSE);
		
		currentPlaytimeProperty.set(0);
	}
	
	public SkipState getRepeatState() {
		return skipStateProperty.get();
	}
	
	public PlayingState getPlayingState() {
		return playingStateProperty.get();
	}
	
	public SimpleObjectProperty<SkipState> skipStateProperty() {
		return skipStateProperty;
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