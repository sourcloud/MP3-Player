package presentation.views.songview;

import business.abstracts.MusicPlayer;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import presentation.components.boxed_labels.SongInfo;
import presentation.components.images.Cover;
import presentation.scenes.ViewController;

public class SongViewController extends ViewController {
	
	private MusicPlayer player;
	
	private SongInfo songInfo;
	private Cover cover;

	public SongViewController(MusicPlayer player) {
		
		this.player = player;
		
		SongView view = new SongView();
		
		this.songInfo = view.songInfo;
		this.cover = view.cover;
		
		rootView = view;
		
		init();
	}
	
	@Override
	public void init() {
		initializeTrackListeners();
		initializeCoverBindings();
	}
	
	public Pane getRootView() {
		return rootView;
	}
	
	private void initializeTrackListeners() {
		
		player.activeTrackProperty().addListener((observable, oldTrack, newTrack) -> {
	
			Platform.runLater(() -> {				
				songInfo.setTitle(newTrack.getTitle());
				songInfo.setArtist(newTrack.getArtist());
				songInfo.setAlbum(newTrack.getAlbum());
				cover.setCover(newTrack.getCover());
			});
		});
	}
	
	private void initializeCoverBindings() {
		
		final double SCALING_FACTOR = 0.9;  // keep margin to window size and other elements
		
		cover.fitWidthProperty().bind(rootView.widthProperty().multiply(SCALING_FACTOR));
		cover.fitHeightProperty().bind((rootView.heightProperty().subtract(songInfo.heightProperty()).multiply(SCALING_FACTOR)));
	}

}
