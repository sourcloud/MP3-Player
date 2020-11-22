package business.abstracts;

import business.data.Track;
import business.interfaces.Player;
import business.services.util.PlayingState;
import business.services.util.RepeatState;
import business.services.util.ShuffleState;
import de.hsrm.mi.eibo.simpleplayer.SimpleAudioPlayer;
import de.hsrm.mi.eibo.simpleplayer.SimpleMinim;

public abstract class MusicPlayer implements Player<Track> {

	protected SimpleMinim minim;
	protected SimpleAudioPlayer audioPlayer;

	protected RepeatState repeatState;
	protected ShuffleState shuffleState;
	protected PlayingState playingState;
	
	public MusicPlayer() {
		minim = new SimpleMinim(true);
		repeatState = RepeatState.NONE;
		shuffleState = ShuffleState.INACTIVE;
		playingState = PlayingState.PAUSE;
	}
	
}