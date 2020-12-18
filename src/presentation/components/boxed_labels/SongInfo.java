package presentation.components.boxed_labels;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SongInfo extends VBox {
	
	private static final String DEFAULT_TITLE = "No Title";
	private static final String DEFAULT_ARTIST = "No Artist";
	private static final String DEFAULT_ALBUM = "No Album";
	
	private Label titleLabel;
	private Label artistLabel;
	private Label albumLabel;
	
	public SongInfo() {
		this(DEFAULT_TITLE, DEFAULT_ARTIST, DEFAULT_ALBUM);
	}
	
	public SongInfo(String title, String artist, String album) {
		
		this.getStyleClass().add("info");
		
		this.titleLabel = new Label((title != null) ? title : DEFAULT_TITLE);
		this.artistLabel = new Label((artist != null) ? artist : DEFAULT_ARTIST);
		this.albumLabel = new Label((album != null) ? album : DEFAULT_ALBUM);
		
		this.getChildren().addAll(
				titleLabel,
				artistLabel,
				albumLabel
		);
		
		titleLabel.getStyleClass().add("title");
		artistLabel.getStyleClass().add("artist");
		albumLabel.getStyleClass().add("album");
		
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
