package presentation.uicomponents.songview;

import business.abstracts.MusicPlayer;
import javafx.scene.layout.Pane;
import presentation.scenes.ViewController;

public class SongViewController extends ViewController {
	
	private MusicPlayer player;
	
	private SongInformation songInfo;
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
		initializeListeners();
	}
	
	public Pane getRootView() {
		return rootView;
	}
	
	private void initializeListeners() {
		
		player.activeTrackProperty().addListener((observable, oldTrack, newTrack) -> {
			
			songInfo.setTitle(newTrack.getTitle());
			songInfo.setArtist(newTrack.getArtist());
			songInfo.setAlbum(newTrack.getAlbum());
			
			cover.setCover(newTrack.getCover());
		});
	}

}
