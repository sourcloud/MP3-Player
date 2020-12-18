package presentation.scenes.playlistscene;

import business.abstracts.MusicPlayer;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import presentation.uicomponents.trackview.TrackViewController;

public class PlaylistScene extends BorderPane {

	public PlaylistScene(MusicPlayer player) {
		
		this.getStylesheets().add(getClass().getResource("playlist_style.css").toExternalForm());		
		Pane playlistView = new TrackViewController(player).getRootView();
		
		this.setCenter(playlistView);

	}

}
