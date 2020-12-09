package presentation.uicomponents.loadview;

import java.io.File;

import business.data.Playlist;
import business.services.MP3Player;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import presentation.scenes.ViewController;

public class LoadViewController extends ViewController {
	
	private MP3Player player;
	private Button loadButton;
	private Label nameLabel;
	
	public LoadViewController(MP3Player player) {

		this.player = player;
		
		LoadView view = new LoadView();
		
		this.loadButton = view.loadButton;
		this.nameLabel = view.nameLabel;
		
		this.rootView = view;
		
		init();
		
	}

	@Override
	public void init() {
		initializeHandlers();
		initializeListeners();
	}
	
	private void initializeHandlers() {
		
		loadButton.addEventHandler(ActionEvent.ACTION, 
			event -> {
				
				File selected = chooseM3U();
				
				if (selected != null)
					player.setPlaylist(new Playlist(selected));
				
			});
	}
	
	private void initializeListeners() {
		
		player.activePlaylistProperty().addListener((observable, oldPlaylist, newPlaylist) -> 
			nameLabel.setText(newPlaylist.getName()) 
		);
		
	}
	
	private File chooseM3U() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(new File("music"));
		fileChooser.setTitle("Open Playlist");
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Playlist Files", "*.m3u"));
		
		return fileChooser.showOpenDialog(new Stage());
	}

}
