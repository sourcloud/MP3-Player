package presentation.scenes.firstscene;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import presentation.uicomponents.controlview.ControlView;
import presentation.uicomponents.songview.SongView;

public class PlayerScene extends BorderPane {
	
	public PlayerScene() {
		
		this.getStylesheets().add("/presentation/scenes/firstscene/style.css");
		
		VBox header = new VBox();
		
		Label title = new Label("Main Scene");
		Label subtitle = new Label("...");
		
		header.getChildren().addAll(title, subtitle);
		
		this.setTop(header);
		
		// center
		Pane songView = new SongView();
		this.setCenter(songView);
		
		// bottom
		Pane controlView = new ControlView();
		this.setBottom(controlView);
	}

}
