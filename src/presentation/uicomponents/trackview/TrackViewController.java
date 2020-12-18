package presentation.uicomponents.trackview;

import business.abstracts.MusicPlayer;
import business.data.Track;
import javafx.collections.ObservableList;
import presentation.scenes.ViewController;

public class TrackViewController extends ViewController {

	private ObservableList<Track> tracks;
	
	public TrackViewController(MusicPlayer player) {
		
		TrackView view = new TrackView();
		
		this.tracks = view.tracks;
		
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
