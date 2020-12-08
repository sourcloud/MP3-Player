package presentation.scenes.firstscene;

import business.services.MP3Player;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import presentation.uicomponents.controlview.ControlViewController;
import presentation.uicomponents.songview.SongViewController;

public class PlayerScene extends BorderPane {
	
	public PlayerScene(MP3Player player) {
		
		this.getStylesheets().add("/presentation/scenes/firstscene/style.css");
		
		VBox header = new VBox();
		
		Label title = new Label("Main Scene");
		Label subtitle = new Label("...");
		
		header.getChildren().addAll(title, subtitle);
		
		this.setTop(header);
		
		// center
		Pane songView = new SongViewController(player).getRootView();
		this.setCenter(songView); 		
		
		// bottom
		Pane controlView = new ControlViewController(player).getRootView();
		this.setBottom(controlView);
	}


}
