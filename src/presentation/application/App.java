package presentation.application;

import java.util.HashMap;
import java.util.Map;

import business.abstracts.MusicPlayer;
import business.services.MP3Player;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.scenes.playerscene.PlayerScene;
import presentation.scenes.tracklistscene.TracklistScene;

public class App extends Application {
	
	public enum Scenes {PLAYER, PLAYLIST};
	
	private Stage primaryStage;
	private Map<Scenes, Pane> scenes;
	
	private MusicPlayer player;

	@Override
	public void init() {
		
		this.player = new MP3Player();
		
		scenes = new HashMap<>();

		scenes.put(Scenes.PLAYER, new PlayerScene(player, this));
		scenes.put(Scenes.PLAYLIST, new TracklistScene(player, this));

	}

	@Override
	public void start(Stage primaryStage) {
			
		this.primaryStage = primaryStage;
		
		primaryStage.setMinHeight(850);
		primaryStage.setMinWidth(500);
		
		BorderPane root = new BorderPane();

		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);

		switchScene(Scenes.PLAYER);
	
		primaryStage.show();
	
		// kill all threads on window close
		primaryStage.setOnCloseRequest(event -> System.exit(0));
	}
	
	public void switchScene() {
		if (primaryStage.getScene().getRoot().equals(scenes.get(Scenes.PLAYER)))
			switchScene(Scenes.PLAYLIST);
		else
			switchScene(Scenes.PLAYER);
	}

	public void switchScene(Scenes nextScene) {
		
		Scene scene = primaryStage.getScene();

		if (scenes.containsKey(nextScene))
			scene.setRoot(scenes.get(nextScene));
	}

	public static void main(String[] args) {
		launch(args);
	}
}
