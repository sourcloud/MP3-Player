package presentation.views.trackview;

import business.abstracts.MusicPlayer;
import business.data.Track;
import javafx.collections.ObservableList;
import javafx.scene.input.MouseEvent;
import presentation.application.App;
import presentation.application.App.Scenes;
import presentation.scenes.ViewController;

public class TrackViewController extends ViewController {

	private MusicPlayer player;
	private ObservableList<Track> tracks;

	private TrackView view;
	private App app;
	
	public TrackViewController(MusicPlayer player, App app) {
		
		this.player = player;
		
		this.view = new TrackView();
		this.app = app;
		this.tracks = view.tracks;
		
		init();
		
	}
	
	public TrackView getView() {
		return view;
	}
	
	@Override
	public void init() {
		initializeListeners();
		initializeHandlers();
	}
	
	private void initializeHandlers() {
		
		view.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			int index = view.getSelectionModel().getSelectedIndex();
			if (index != -1) {				
				player.getPlaylist().setCurrentIndex(index);
				player.play();
				app.switchScene(Scenes.PLAYER);
			}
		});
	}
	
	private void initializeListeners() {
		
		player.activePlaylistProperty().addListener((observable, oldPlaylist, newPlaylist) -> {
			tracks.setAll(newPlaylist.getTracklist());
			view.setItems(tracks);
		});
		
	}
	

}
