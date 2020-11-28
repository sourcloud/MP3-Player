package presentation.uicomponents.songview;

import java.io.FileNotFoundException;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class SongView extends StackPane {

	private VBox cover;
	private VBox songInfo;

	public SongView() {
		
		try {
			
			cover = new Cover();
			this.getChildren().add(cover);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		songInfo = new SongInformation();
		this.getChildren().add(songInfo);
		
		cover.setAlignment(Pos.TOP_LEFT);
		songInfo.setAlignment(Pos.TOP_LEFT);
		
		this.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
	}
	
}
