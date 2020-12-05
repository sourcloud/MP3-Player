package presentation.uicomponents.controlview;

import business.services.MP3Player;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
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
		
		this.playPauseButton = view.playPauseButton;
		this.stopButton = view.stopButton;
		this.skipButton = view.skipButton;
		this.repeatButton = view.repeatButton;
		this.shuffleButton = view.shuffleButton;
		this.skipBackButton = view.skipBackButton;
		
		rootView = view;
		
		init();
	}
	
	
	@Override
	public void init() {
		
		playPauseButton.addEventHandler(ActionEvent.ACTION, 
			event -> {
				
				if (!player.getPlayingState().playing())				
					player.play();
				else
					player.pause();
				
				updateGUI();
			});
		
		stopButton.addEventHandler(ActionEvent.ACTION, 
				event -> {
					player.stop();
					updateGUI();
				});
		
		skipButton.addEventHandler(ActionEvent.ACTION, 
				event -> {
					player.skip();
					updateGUI();
				});
		
		skipBackButton.addEventHandler(ActionEvent.ACTION, 
				event -> {
					player.skipBack();
					updateGUI();
				});
		
		repeatButton.addEventHandler(ActionEvent.ACTION, 
				event -> {
					player.toggleRepeat();
					updateGUI();
				});
		
		shuffleButton.addEventHandler(ActionEvent.ACTION, 
				event -> {
					player.toggleShuffle();
					updateGUI();
				});
		
	}
	
	public Pane getRootView() {
		return rootView;
	}
	
	private void updateGUI() {
		updatePlayButtonGUI();
		updateRepeatButtonGUI();
		updateShuffleButtonGUI();
	}
	
	private void updatePlayButtonGUI() {
		if (player.getPlayingState().playing())
			playPauseButton.setText(ControlView.PAUSE_SIGN);
		else
			playPauseButton.setText(ControlView.PLAY_SIGN);
	}
	
	private void updateRepeatButtonGUI() {
		
		if (player.getRepeatState().repeatAll()) {
			// update
		} else if (player.getRepeatState().repeatOne()) {
			// update
		} else
			repeatButton.setText(ControlView.REPEAT_SIGN);
	}
	
	private void updateShuffleButtonGUI() {
		if (player.getShuffleState().active()) {
			// update
		} else {
			shuffleButton.setText(ControlView.SHUFFLE_SIGN);
		}
	}

}
