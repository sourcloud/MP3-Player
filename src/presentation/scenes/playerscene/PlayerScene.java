package presentation.scenes.playerscene;

import business.abstracts.MusicPlayer;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import presentation.views.controlview.ControlViewController;
import presentation.views.loadview.LoadViewController;
import presentation.views.songview.SongViewController;

public class PlayerScene extends BorderPane {
	
	public PlayerScene(MusicPlayer player) {
		
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
