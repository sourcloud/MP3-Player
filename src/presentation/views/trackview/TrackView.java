package presentation.views.trackview;

import business.data.Track;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class TrackView extends ListView<Track> {

	protected ObservableList<Track> tracks;
	
	public TrackView() {
		
		tracks = FXCollections.observableArrayList();
		
		
	}
	
	
}
