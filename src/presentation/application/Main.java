package presentation.application;

import java.util.HashMap;
import java.util.Map;

import business.data.Playlist;
import business.services.MP3Player;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.scenes.firstscene.PlayerScene;
import presentation.scenes.secondscene.SecondScene;
import presentation.scenes.thirdscene.ThirdScene;

public class Main extends Application {
	
	public enum Scenes {FIRST_SCENE, SECOND_SCENE, THIRD_SCENE};
	
	private Stage primaryStage;
	private Map<Scenes, Pane> scenes;
	
	private MP3Player player;

	@Override
	public void init() {
		
		this.player = new MP3Player();
		
		scenes = new HashMap<>();

		scenes.put(Scenes.FIRST_SCENE, new PlayerScene(player));
		scenes.put(Scenes.SECOND_SCENE, new SecondScene());
		scenes.put(Scenes.THIRD_SCENE, new ThirdScene());
		
	}

	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			this.primaryStage = primaryStage;
			primaryStage.setMinHeight(750);
			primaryStage.setMinWidth(500);
			
			BorderPane root = new BorderPane();

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);

			switchScene(Scenes.FIRST_SCENE);

			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void switchScene(Scenes toScene) {
		
		Scene scene = primaryStage.getScene();

		if (scenes.containsKey(toScene)) {
			scene.setRoot(scenes.get(toScene));
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
