package presentation.scenes.secondscene;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import presentation.uicomponents.controlview.ControlView;

public class SecondScene extends BorderPane {
	
	Label title;

	public SecondScene() {
		
		title = new Label("Screen 2");
		this.setTop(title);

		this.setBottom(new ControlView());
	}

}
