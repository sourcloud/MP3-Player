package presentation.uicomponents.songview;

import javafx.scene.layout.AnchorPane;

public class SongView extends AnchorPane {

	public SongView() {
	
		CoverAndInfoStack coverAndInfo = new CoverAndInfoStack();		
		this.getChildren().add(coverAndInfo);
		
		this.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		
	}
	
}
