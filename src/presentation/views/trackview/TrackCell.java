package presentation.views.trackview;

import business.data.Track;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import presentation.components.boxed_labels.SongInfo;
import presentation.components.images.Cover;

public class TrackCell extends ListCell<Track> {

	@Override
	protected void updateItem(Track track, boolean empty) {
		
		super.updateItem(track, empty);
		
		setText(null);
		setGraphic(null);
		
		if (track != null) {
			
			HBox box = new HBox();
			
			box.getStyleClass().add("listitem");
			
			box.getChildren().addAll(
				new Cover(track.getCover(), 100, 100),	
				new SongInfo(track.getTitle(), track.getArtist(), track.getAlbum())
			);
			
			setGraphic(box);
		}
		
		
	}
	
}
