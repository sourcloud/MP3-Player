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
			defaultImage = new Image(fis, 500, 500, false, true);
			this.setImage(defaultImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Cover(byte[] coverImageArray) {
		
		this();
		setCover(coverImageArray);
		
	}
	
	public void setCover(byte[] coverImageArray) {
		
		if (coverImageArray != null) {			
			try (ByteArrayInputStream bis = new ByteArrayInputStream(coverImageArray)) {
				this.setImage(new Image(bis, 500, 500, false, true));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
