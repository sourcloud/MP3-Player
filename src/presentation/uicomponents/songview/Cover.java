package presentation.uicomponents.songview;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Cover extends ImageView {
	
	private final static String DEFAULT_PATH = "img/no-cover.jpg";
	
	private Image defaultImage;

	public Cover() {	
		
		super();
		
		try (FileInputStream fis = new FileInputStream(DEFAULT_PATH)) {
			defaultImage = new Image(fis, 500, 500, true, true);
			setImage(defaultImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setPreserveRatio(true);
		
	}
	
	public Cover(byte[] coverImageArray) {
		
		this();
		setCover(coverImageArray);
		
	}
	
	public void setCover(byte[] coverImageArray) {
				
		try (ByteArrayInputStream bis = new ByteArrayInputStream(coverImageArray)) {
			setImage(new Image(bis, 500, 500, true, true));
			
		} catch (IOException e) {
			setImage(defaultImage);
		}
	}	

}
