package presentation.views.trackview;

import business.data.Track;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class TrackView extends ListView<Track> {

	protected ObservableList<Track> tracks;
	
	public TrackView() {
		
		tracks = FXCollections.observableArrayList();
		
		this.setCellFactory(e -> new TrackCell());
		this.getStylesheets().add(getClass().getResource("track_style.css").toExternalForm());
		
	}
	
	
}
