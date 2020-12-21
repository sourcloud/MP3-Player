package presentation.views.controlview;

import business.abstracts.MusicPlayer;
import business.services.util.MathUtil;
import business.services.util.PlayingState;
import business.services.util.ShuffleState;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import presentation.application.App;
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

	public ControlViewController(MusicPlayer player, App app) {
		
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
		initializeButtonHandlers();
		initializeSliderHandlers();
		
		initializeStateListeners();
		initializePlayerTrackListeners();
		initializeSliderListeners();
	}
	
	public Pane getRootView() {
		return rootView;
	}
	
	private void initializeButtonHandlers() {
		
		playPauseButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			if (!player.getPlayingState().playing())
				player.play();
			else
				player.pause();
		});
		
		stopButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> player.stop() );
		skipButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> player.skip() );
		repeatButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> player.toggleRepeat() );		
		shuffleButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> player.toggleShuffle() );
		skipBackButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> player.skipBack() );
	}
	
	private void initializeSliderHandlers() {
		
		timeSlider.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> player.skipTo((int) timeSlider.getValue()) );
		
		timeSlider.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {	
			int newValue = (int) (event.getX() / timeSlider.getWidth() * timeSlider.getMax());
			player.skipTo(newValue);		
		});
	}
	
	private void initializeStateListeners() {
		
		player.playingStateProperty().addListener((observable, oldState, newState) -> {
			
			String newSign = newState.equals(PlayingState.PLAY) 
								? Symbol.PAUSE.unicode() 
								: Symbol.PLAY.unicode();
			
			Platform.runLater(() -> playPauseButton.setText(newSign));
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
	}
	
	private void initializePlayerTrackListeners() {
		
		player.activeTrackProperty().addListener((observable, oldTrack, newTrack) -> {
			
			int seconds = newTrack.getLength() / 1000;
			
			maxTimeLabel.setText("%d:%02d".formatted(seconds / 60, seconds % 60));		
			timeSlider.setMax(newTrack.getLength());
		});
		
		
		player.currentPlaytimeProperty().addListener((observable, oldValue, newValue) -> {
	
			int seconds = newValue.intValue() / 1000;
			
			Platform.runLater(() ->  {
				currentTimeLabel.setText("%d:%02d".formatted(seconds / 60, seconds % 60));
				timeSlider.setValue(newValue.intValue());
			});
			
		});
		
	}
	
	private void initializeSliderListeners() {
		volumeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
			float dbValue = MathUtil.convertLinearToDB(newValue.floatValue());
			player.volume(dbValue);
		});
	}

}
