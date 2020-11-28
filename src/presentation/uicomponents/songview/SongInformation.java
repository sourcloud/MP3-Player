package presentation.uicomponents.songview;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SongInformation extends VBox {
	
	private String title = "Some Title";
	private String artist = "Some Artist";
	private String album = "Some Album";
	
	public SongInformation() {
		
		this.getStyleClass().add("info");

		Label titleLabel = new Label(title);
		Label artistLabel = new Label(artist);
		Label albumLabel = new Label(album);
		
		this.getChildren().addAll(
			titleLabel,
			artistLabel,
			albumLabel
		);
		
	}

}
