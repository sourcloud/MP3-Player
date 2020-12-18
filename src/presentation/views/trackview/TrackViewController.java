package presentation.views.trackview;

import business.abstracts.MusicPlayer;
import business.data.Track;
import javafx.collections.ObservableList;
import presentation.scenes.ViewController;

public class TrackViewController extends ViewController {

	private MusicPlayer player;
	private ObservableList<Track> tracks;
	
	private TrackView view;
	
	public TrackViewController(MusicPlayer player) {
		
		this.player = player;
		
		this.view = new TrackView();
		
		this.tracks = view.tracks;
		
		init();
		
	}
	
	public TrackView getView() {
		return view;
	}
	
	@Override
	public void init() {
		initializeListeners();
	}
	
	private void initializeListeners() {
		
		player.activePlaylistProperty().addListener((observable, oldPlaylist, newPlaylist) -> {
			tracks.clear();
			tracks.setAll(newPlaylist.getTracklist());
			view.setItems(tracks);
		});
		
	}
	

}
