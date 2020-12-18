package presentation.components.boxed_labels;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SongInformation extends VBox {
	
	private static final String DEFAULT_TITLE = "No Title";
	private static final String DEFAULT_ARTIST = "No Artist";
	private static final String DEFAULT_ALBUM = "No Album";
	
	private Label titleLabel;
	private Label artistLabel;
	private Label albumLabel;
	
	public SongInformation() {
		
		this.getStyleClass().add("info");

		this.titleLabel = new Label(DEFAULT_TITLE);
		this.artistLabel = new Label(DEFAULT_ARTIST);
		this.albumLabel = new Label(DEFAULT_ALBUM);
		
		this.getChildren().addAll(
			titleLabel,
			artistLabel,
			albumLabel
		);
		
		this.setAlignment(Pos.BOTTOM_CENTER);
		
	}
	
	public void setTitle(String title) {
		String toSet = (title != null && !title.isBlank()) ? title : DEFAULT_TITLE;
		titleLabel.setText(toSet);
	}
	
	public void setArtist(String artist) {
		String toSet = (artist != null && !artist.isBlank()) ? artist : DEFAULT_ARTIST;
		artistLabel.setText(toSet);
	}
	
	public void setAlbum(String album) {
		String toSet = (album != null && !album.isBlank()) ? album : DEFAULT_ARTIST;
		albumLabel.setText(toSet);
	}

}
