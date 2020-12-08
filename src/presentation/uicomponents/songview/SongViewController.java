package presentation.uicomponents.songview;

import business.data.Track;
import business.services.MP3Player;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.Pane;
import presentation.scenes.ViewController;

public class SongViewController extends ViewController {
	
	private MP3Player player;
	
	private SongInformation songInfo;
	private Cover cover;

	public SongViewController(MP3Player player) {
		
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
		player.activeTrackProperty().addListener(
			new ChangeListener<>() {

				@Override
				public void changed(ObservableValue<? extends Track> observable, Track oldTrack, Track newTrack) {
					songInfo.setTitle(newTrack.getTitle());
					songInfo.setArtist(newTrack.getArtist());
					songInfo.setAlbum(newTrack.getAlbum());
					
					cover.setCover(newTrack.getCover());
				}
				
			});
	}

}
