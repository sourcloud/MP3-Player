package presentation.uicomponents.controlview;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import presentation.uicomponents.buttons.pausebutton.PauseButton;
import presentation.uicomponents.buttons.playbutton.PlayButton;
import presentation.uicomponents.buttons.repeatbutton.RepeatButton;
import presentation.uicomponents.buttons.shufflebutton.ShuffleButton;
import presentation.uicomponents.buttons.skipbackButton.SkipBackButton;
import presentation.uicomponents.buttons.skipbutton.SkipButton;
import presentation.uicomponents.buttons.stopbutton.StopButton;

public class ControlView extends HBox {
	
	private Button pauseButton;
	private Button playButton;
	private Button repeatButton;
	private Button shuffleButton;
	private Button skipButton;
	private Button skipBackButton;
	private Button stopButton;

	public ControlView() {

		repeatButton = new RepeatButton("repeat");
		pauseButton = new PauseButton("pause");
		skipBackButton = new SkipBackButton("skipBack");
		playButton = new PlayButton("play");
		skipButton = new SkipButton("skip");
		stopButton = new StopButton("stop");
		shuffleButton = new ShuffleButton("shuffle");

		this.getChildren().addAll(repeatButton, pauseButton, skipBackButton, playButton, skipButton, stopButton, shuffleButton);
		this.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		
	}
}
