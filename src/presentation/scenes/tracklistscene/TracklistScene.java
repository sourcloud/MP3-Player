package presentation.scenes.tracklistscene;

import business.abstracts.MusicPlayer;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import presentation.views.loadview.LoadViewController;
import presentation.views.trackview.TrackView;
import presentation.views.trackview.TrackViewController;

public class TracklistScene extends BorderPane {

	public TracklistScene(MusicPlayer player) {
		
		this.getStylesheets().add(getClass().getResource("tracklist_style.css").toExternalForm());		
		
		Pane loadView = new LoadViewController(player).getRootView();
		this.setTop(loadView);
		
		TrackView tracklistView = new TrackViewController(player).getView();
		this.setCenter(tracklistView);
		
	}

}
