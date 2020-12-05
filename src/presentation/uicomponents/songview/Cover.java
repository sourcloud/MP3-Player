package presentation.uicomponents.songview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Cover extends ImageView {
	
	private final static String DEFAULT_PATH = "img/no-cover.jpg";

	public Cover() throws FileNotFoundException {	
		
		super(new Image(new FileInputStream(DEFAULT_PATH)));
		
	}
	
	
}
