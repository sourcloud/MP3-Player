package business.abstracts;

import business.data.Track;
import business.interfaces.MediaPlayer;
import business.services.util.PlayingState;
import business.services.util.RepeatState;
import business.services.util.ShuffleState;
import de.hsrm.mi.eibo.simpleplayer.SimpleAudioPlayer;
import de.hsrm.mi.eibo.simpleplayer.SimpleMinim;
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
	
	public MusicPlayer() {
		
		minim = new SimpleMinim(true);
		
		repeatStateProperty = new SimpleObjectProperty<>();
		shuffleStateProperty = new SimpleObjectProperty<>();
		playingStateProperty = new SimpleObjectProperty<>();
		
		repeatState = RepeatState.NONE;
		shuffleState = ShuffleState.INACTIVE;
		playingState = PlayingState.PAUSE;
		
		repeatStateProperty.set(repeatState);
		shuffleStateProperty.set(shuffleState);
		playingStateProperty.set(playingState);
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
	
}