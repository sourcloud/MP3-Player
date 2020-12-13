package presentation.uicomponents.controlview;

import business.abstracts.MusicPlayer;
import business.services.util.MathUtil;
import business.services.util.PlayingState;
import business.services.util.ShuffleState;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import presentation.application.AppColor;
import presentation.scenes.ViewController;

public class ControlViewController extends ViewController {
	
	private MusicPlayer player;
	
	private Button playPauseButton;
	private Button stopButton;
	private Button skipButton;
	private Button repeatButton;
	private Button shuffleButton;
	private Button skipBackButton;
	
	private Label currentTimeLabel;
	private Label maxTimeLabel;
	
	private Slider timeSlider;
	private Slider volumeSlider;

	public ControlViewController(MusicPlayer player) {
		
		this.player = player;
		
		ControlView view = new ControlView();
		
		this.playPauseButton = view.buttonMap.get(Symbol.PLAY);
		this.stopButton = view.buttonMap.get(Symbol.STOP);
		this.skipButton = view.buttonMap.get(Symbol.SKIP);
		this.repeatButton = view.buttonMap.get(Symbol.REPEAT);
		this.shuffleButton = view.buttonMap.get(Symbol.SHUFFLE);
		this.skipBackButton = view.buttonMap.get(Symbol.SKIPBACK);
		
		this.currentTimeLabel = view.currentTimeLabel;
		this.maxTimeLabel = view.maxTimeLabel;
		this.timeSlider = view.timeSlider;
		
		this.volumeSlider = view.volumeSlider;
		
		rootView = view;
		
		init();
	}
	
	
	@Override
	public void init() {
		initializeBindings();
		initializeHandlers();
		initializeListeners();
	}
	
	public Pane getRootView() {
		return rootView;
	}
	
	private void initializeBindings() {
		
		// timeSlider.valueProperty().bind(player.currentPlaytimeProperty());
		
	}
	
	private void initializeHandlers() {
		
		
		// Play/Pause button changes functionality based on player's state
		
		playPauseButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			if (!player.getPlayingState().playing())
				player.play();
			else
				player.pause();
		});
			
		
		// Control buttons perform corresponding player action
		
		stopButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> player.stop() );
		skipButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> player.skip() );
		repeatButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> player.toggleRepeat() );		
		shuffleButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> player.toggleShuffle() );
		skipBackButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> player.skipBack() );
		
		// Drag slider to skip track to new time
		
		timeSlider.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> player.skipTo((int) timeSlider.getValue()) );
		
		// Click on slider to skip track to new time
		
		timeSlider.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			
			int newValue = (int) (event.getX() / timeSlider.getWidth() * timeSlider.getMax());
			timeSlider.setValue(newValue);
			player.skipTo(newValue);
			
		});
		
		// Drag slider to adjust volume
		
		volumeSlider.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> 
			player.volume(MathUtil.convertLinearToDB((float) volumeSlider.getValue())));
		
		// Click on slider to adjust volume
		
		volumeSlider.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

			float newValue = (float) (event.getX() / volumeSlider.getWidth() * volumeSlider.getMax());
			volumeSlider.setValue(newValue);
			player.volume(MathUtil.convertLinearToDB(newValue));
		});
		
	}
	
	
	private void initializeListeners() {
		
		player.playingStateProperty().addListener((observable, oldState, newState) -> {
			
			String newSign = newState.equals(PlayingState.PLAY) 
								? Symbol.PAUSE.unicode() 
								: Symbol.PLAY.unicode();
			
			playPauseButton.setText(newSign);
		});
		
		
		player.shuffleStateProperty().addListener((observable, oldState, newState) -> {
			
			Color newColor = newState.equals(ShuffleState.ACTIVE) 
								? AppColor.ACCENT_1.color() 
								: AppColor.INACTIVE.color();
								
			shuffleButton.setTextFill(newColor);
		});
		
		
		player.repeatStateProperty().addListener((observable, oldState, newState) -> {
				
			Color newColor;
			
			switch(newState) {
				case ALL:
					newColor = AppColor.ACCENT_1.color();
					break;
				case SINGLE:
					newColor = AppColor.ACCENT_2.color();
					break;
				case NONE: // FALLTHROUGH
				default:
					newColor = AppColor.INACTIVE.color();
					break;
			}
			repeatButton.setTextFill(newColor);
		});
		
		
		player.activeTrackProperty().addListener((observable, oldTrack, newTrack) -> {
			
			int timeInSeconds = MathUtil.convertMillisecondsToSeconds(newTrack.getLength());
			int fullMinutes = MathUtil.fullMinuteSeconds(timeInSeconds);
			int leftoverSeconds = MathUtil.leftoverSeconds(timeInSeconds);
			
			maxTimeLabel.setText("%d:%02d".formatted(fullMinutes, leftoverSeconds));
			
			timeSlider.setMax(newTrack.getLength());
			
		});
		
		
		player.currentPlaytimeProperty().addListener((observable, oldValue, newValue) -> {
	
			int timeInSeconds = MathUtil.convertMillisecondsToSeconds(newValue.intValue());
			int fullMinutes = MathUtil.fullMinuteSeconds(timeInSeconds);
			int leftoverSeconds = MathUtil.leftoverSeconds(timeInSeconds);
			
			currentTimeLabel.setText("%d:%02d".formatted(fullMinutes, leftoverSeconds));
			
			timeSlider.setValue(newValue.intValue());
			
		});
		
	}

}
