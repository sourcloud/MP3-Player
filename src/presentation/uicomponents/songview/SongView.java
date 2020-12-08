package presentation.uicomponents.songview;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class SongView extends AnchorPane {

	protected Cover cover;
	protected SongInformation songInfo;
	
	public SongView() {
			
		cover = new Cover();
		this.getChildren().add(cover);
		
		songInfo = new SongInformation();
		this.getChildren().add(songInfo);
		
		cover.maxHeight(400);
		cover.maxWidth(400);

	}
	
	public ImageView getCover() {
		return cover;
	}
}
