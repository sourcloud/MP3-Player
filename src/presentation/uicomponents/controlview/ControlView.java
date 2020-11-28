package presentation.uicomponents.controlview;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import presentation.uicomponents.buttons.RoundButton;

public class ControlView extends HBox {
	
	private static final String PLAY_SIGN = "\u25B6";
	private static final String SKIP_SIGN = "\u25B6\u25AE";
	private static final String SKIPBACK_SIGN = "\u25AE\u25C0";
	private static final String PAUSE_SIGN = "\u25AE\u25AE";
	private static final String STOP_SIGN = "\u25A0";
	private static final String REPEAT_SIGN = "\u27F2";
	private static final String SHUFFLE_SIGN = "\u292E";
	
	private Button playButton;
	private Button stopButton;
	private Button skipButton;
	private Button pauseButton;
	private Button repeatButton;
	private Button shuffleButton;
	private Button skipBackButton;

	public ControlView() {

		initializeButtons();

		this.getChildren().addAll(
				repeatButton, 
				pauseButton, 
				skipBackButton, 
				playButton, 
				skipButton, 
				stopButton, 
				shuffleButton
		);
		
		this.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		
	}
	
	private void initializeButtons() {

		skipButton = new RoundButton(SKIP_SIGN);
		stopButton = new RoundButton(STOP_SIGN);
		playButton = new RoundButton(PLAY_SIGN);
		pauseButton = new RoundButton(PAUSE_SIGN);
		repeatButton = new RoundButton(REPEAT_SIGN);
		shuffleButton = new RoundButton(SHUFFLE_SIGN);
		skipBackButton = new RoundButton(SKIPBACK_SIGN);
		
	}
	
}
