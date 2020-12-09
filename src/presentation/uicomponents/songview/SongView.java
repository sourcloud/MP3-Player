package presentation.uicomponents.songview;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class SongView extends VBox {

	protected Cover cover;
	protected SongInformation songInfo;
	
	public SongView() {
			
		cover = new Cover();
		songInfo = new SongInformation();

		this.getChildren().addAll(cover, songInfo);
		
		this.setAlignment(Pos.CENTER);
		
		this.getStylesheets().add(getClass().getResource("song_style.css").toExternalForm());

	}
	
	public ImageView getCover() {
		return cover;
	}
}
