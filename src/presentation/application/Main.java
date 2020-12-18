package presentation.application;

import java.util.HashMap;
import java.util.Map;

import business.abstracts.MusicPlayer;
import business.data.Playlist;
import business.data.util.M3U_IO;
import business.services.MP3Player;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.scenes.playerscene.PlayerScene;
import presentation.scenes.tracklistscene.TracklistScene;

public class Main extends Application {
	
	public enum Scenes {FIRST_SCENE, SECOND_SCENE};
	
	private Stage primaryStage;
	private Map<Scenes, Pane> scenes;
	
	private MusicPlayer player;

	@Override
	public void init() {
		
		this.player = new MP3Player();
		
		scenes = new HashMap<>();

		scenes.put(Scenes.FIRST_SCENE, new PlayerScene(player));
		scenes.put(Scenes.SECOND_SCENE, new TracklistScene(player));
		
	}

	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			this.primaryStage = primaryStage;
			
			primaryStage.setMinHeight(850);
			primaryStage.setMinWidth(500);
			
			BorderPane root = new BorderPane();

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);

			switchScene(Scenes.FIRST_SCENE);
			
			switchScene(Scenes.SECOND_SCENE);

			
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// kill all threads on window close
		primaryStage.setOnCloseRequest(event -> System.exit(0));
	}

	public void switchScene(Scenes toScene) {
		
		Scene scene = primaryStage.getScene();

		if (scenes.containsKey(toScene))
			scene.setRoot(scenes.get(toScene));
	}

	public static void main(String[] args) {
		launch(args);
	}
}
