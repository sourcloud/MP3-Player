package presentation.uicomponents.songview;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SongInformation extends VBox {
	
	private final String defaultTitle = "Some Title";
	private final String defaultArtist = "Some Artist";
	private final String defaultAlbum = "Some Album";
	
	private Label titleLabel;
	private Label artistLabel;
	private Label albumLabel;
	
	public SongInformation() {
		
		this.getStyleClass().add("info");

		this.titleLabel = new Label(defaultTitle);
		this.artistLabel = new Label(defaultArtist);
		this.albumLabel = new Label(defaultAlbum);
		
		this.getChildren().addAll(
			titleLabel,
			artistLabel,
			albumLabel
		);
		
	}
	
	public void setTitle(String title) {
		titleLabel.setText(title);
	}
	
	public void setArtist(String artist) {
		artistLabel.setText(artist);
	}
	
	public void setAlbum(String album) {
		albumLabel.setText(album);
	}

}
