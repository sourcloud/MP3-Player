package presentation.uicomponents.loadview;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import presentation.application.AppColor;

public class LoadView extends HBox {
	
	public static final String LOAD_PLAYLIST = "No active playlist";
	
	protected Label nameLabel;
	protected Button loadButton;
	
	public LoadView() {
		
		nameLabel = new Label(LOAD_PLAYLIST);
		loadButton = new Button(" ... ");

		Color fillColor = AppColor.ACCENT_1.color();
		loadButton.setTextFill(fillColor);
		loadButton.setPrefWidth(40);
		
		this.getChildren().addAll(nameLabel, loadButton);
								
		this.setAlignment(Pos.CENTER);
		
		this.getStylesheets().add(getClass().getResource("load_style.css").toExternalForm());
	}

}
