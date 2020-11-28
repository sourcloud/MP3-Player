package presentation.uicomponents.songview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Cover extends VBox {
	
	private final static String DEFAULT_PATH = "img/no-cover.jpg";

	public Cover() throws FileNotFoundException {	
		
		this.getStyleClass().add("cover");
		
		FileInputStream fileStream = new FileInputStream(DEFAULT_PATH);
		
		Image coverImage = new Image(fileStream);
		ImageView coverView = new ImageView(coverImage);
		
		this.getChildren().add(coverView);
	}
	
	
}
