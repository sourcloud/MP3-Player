package presentation.uicomponents.loadview;

import java.io.File;

import business.abstracts.MusicPlayer;
import business.data.Playlist;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import presentation.scenes.ViewController;

public class LoadViewController extends ViewController {
	
	private MusicPlayer player;
	private Button loadButton;
	private Label nameLabel;
	
	public LoadViewController(MusicPlayer player) {

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
		
		loadButton.addEventHandler(MouseEvent.MOUSE_CLICKED, 
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
