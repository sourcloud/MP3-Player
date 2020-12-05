package presentation.uicomponents.songview;

import java.io.FileNotFoundException;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class CoverAndInfoStack extends StackPane {
	
	private ImageView cover;
	private VBox songInfo;
	
	public CoverAndInfoStack() {
		
		try {
			
			cover = new Cover();
			this.getChildren().add(cover);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		songInfo = new SongInformation();
		this.getChildren().add(songInfo);

	}
	
	public ImageView getCover() {
		return cover;
	}

	
}
