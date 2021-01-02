package presentation.views.songview;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import presentation.components.boxed_labels.SongInfo;
import presentation.components.images.Cover;

public class SongView extends VBox {

	protected Cover cover;
	protected SongInfo songInfo;
	
	public SongView() {
			
		cover = new Cover();
		
		songInfo = new SongInfo();
		songInfo.setAlignment(Pos.BOTTOM_CENTER);

		this.getChildren().addAll(cover, songInfo);
		
		this.setAlignment(Pos.CENTER);
		
		this.getStylesheets().add(getClass().getResource("song_style.css").toExternalForm());

	}

}
