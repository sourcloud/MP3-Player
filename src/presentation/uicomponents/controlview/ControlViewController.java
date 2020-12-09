package presentation.uicomponents.controlview;

import business.services.MP3Player;
import business.services.util.PlayingState;
import business.services.util.ShuffleState;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import presentation.application.AppColor;
import presentation.scenes.ViewController;

public class ControlViewController extends ViewController {
	
	private MP3Player player;
	
	private Button playPauseButton;
	private Button stopButton;
	private Button skipButton;
	private Button repeatButton;
	private Button shuffleButton;
	private Button skipBackButton;

	public ControlViewController(MP3Player player) {
		
		this.player = player;
		
		ControlView view = new ControlView();
		
		this.playPauseButton = view.buttonMap.get(Symbol.PLAY);
		this.stopButton = view.buttonMap.get(Symbol.STOP);
		this.skipButton = view.buttonMap.get(Symbol.SKIP);
		this.repeatButton = view.buttonMap.get(Symbol.REPEAT);
		this.shuffleButton = view.buttonMap.get(Symbol.SHUFFLE);
		this.skipBackButton = view.buttonMap.get(Symbol.SKIPBACK);
		
		rootView = view;
		
		init();
	}
	
	
	@Override
	public void init() {
		initializeHandlers();
		initializeListeners();
	}
	
	public Pane getRootView() {
		return rootView;
	}
	
	private void initializeHandlers() {
		
		playPauseButton.addEventHandler(ActionEvent.ACTION, 
				event -> {

					if (!player.getPlayingState().playing())
						player.play();
					else
						player.pause();
				});
			
		stopButton.addEventHandler(ActionEvent.ACTION, event -> player.stop() );
		skipButton.addEventHandler(ActionEvent.ACTION, event -> player.skip() );
		repeatButton.addEventHandler(ActionEvent.ACTION, event -> player.toggleRepeat() );		
		shuffleButton.addEventHandler(ActionEvent.ACTION, event -> player.toggleShuffle() );
		skipBackButton.addEventHandler(ActionEvent.ACTION, event -> player.skipBack() );
	}
	
	
	private void initializeListeners() {
		
			player.playingStateProperty().addListener((observable, oldValue, newValue) -> {
				
				String newSign = newValue.equals(PlayingState.PLAY) 
									? Symbol.PAUSE.unicode() 
									: Symbol.PLAY.unicode();
				
				playPauseButton.setText(newSign);
			});
			
			player.shuffleStateProperty().addListener((observable, oldValue, newValue) -> {
				
				Color newColor = newValue.equals(ShuffleState.ACTIVE) 
									? AppColor.ACCENT_1.color() 
									: AppColor.INACTIVE.color();
									
				shuffleButton.setTextFill(newColor);
			});
			
			player.repeatStateProperty().addListener((observable, oldValue, newValue) -> {
					
				Color newColor;
				switch(newValue) {
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

}
