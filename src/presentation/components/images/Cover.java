package presentation.components.images;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Cover extends ImageView {
	
	private static final String DEFAULT_PATH = "img/no-cover.jpg";
	private static final double DEFAULT_HEIGHT = 500;
	private static final double DEFAULT_WIDTH = 500;
	
	private Image defaultImage;
	
	private double standardHeight;
	private double standardWidth;

	public Cover() {	
		this(DEFAULT_HEIGHT, DEFAULT_WIDTH);
	}
	
	public Cover(double height, double width) {
		
		super();
		
		this.standardHeight = height;
		this.standardWidth = width;
		
		try (FileInputStream fis = new FileInputStream(DEFAULT_PATH)) {
			defaultImage = new Image(fis, standardWidth, standardHeight, true, true);
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
			setImage(new Image(bis, standardWidth, standardHeight, true, true));
		} catch (IOException e) {
			setImage(defaultImage);
		}
	}	

}
