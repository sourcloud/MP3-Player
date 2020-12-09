package presentation.scenes.firstscene;

import business.services.MP3Player;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import presentation.uicomponents.controlview.ControlViewController;
import presentation.uicomponents.loadview.LoadViewController;
import presentation.uicomponents.songview.SongViewController;

public class PlayerScene extends BorderPane {
	
	public PlayerScene(MP3Player player) {
		
		this.getStylesheets().add(getClass().getResource("player_style.css").toExternalForm());
		
		// top
		Pane loadView = new LoadViewController(player).getRootView();
		this.setTop(loadView);
		
		// center
		Pane songView = new SongViewController(player).getRootView();
		this.setCenter(songView); 		
		
		// bottom
		Pane controlView = new ControlViewController(player).getRootView();
		this.setBottom(controlView);
		
	}

}
