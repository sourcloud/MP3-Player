package presentation.uicomponents.controlview;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import presentation.uicomponents.buttons.RoundButton;

public class ControlView extends HBox {
	
	public static final String PLAY_SIGN = "\u25B6";
	public static final String SKIP_SIGN = "\u25B6\u25AE";
	public static final String SKIPBACK_SIGN = "\u25AE\u25C0";
	public static final String PAUSE_SIGN = "\u25AE\u25AE";
	public static final String STOP_SIGN = "\u25A0";
	public static final String REPEAT_SIGN = "\u27F2";
	public static final String SHUFFLE_SIGN = "\u292E";
	
	Button playPauseButton;
	Button stopButton;
	Button skipButton;
	Button repeatButton;
	Button shuffleButton;
	Button skipBackButton;

	public ControlView() {

		initializeButtons();

		this.getChildren().addAll(
				repeatButton, 
				skipBackButton, 
				stopButton, 
				playPauseButton, 
				skipButton, 
				shuffleButton
		);
		
		this.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		
	}
	
	private void initializeButtons() {

		playPauseButton = new RoundButton(PLAY_SIGN);
		stopButton = new RoundButton(STOP_SIGN);
		skipButton = new RoundButton(SKIP_SIGN);
		repeatButton = new RoundButton(REPEAT_SIGN);
		shuffleButton = new RoundButton(SHUFFLE_SIGN);
		skipBackButton = new RoundButton(SKIPBACK_SIGN);
		
	}
	
}
