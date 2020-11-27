package presentation.scenes.firstscene;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import presentation.uicomponents.controlview.ControlView;

public class MainScene extends BorderPane {
	
	public MainScene() {
		
		VBox header = new VBox();
		
		Label title = new Label("Main Scene");
		Label subtitle = new Label("...");
		
		header.getChildren().addAll(title, subtitle);
		
		this.setTop(header);
		
		Pane controlView = new ControlView();
		this.setBottom(controlView);
	}

}
