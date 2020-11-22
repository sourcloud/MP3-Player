package business.services;

import business.data.Playlist;
import business.data.Track;
import business.interfaces.Controller;
import business.interfaces.Player;
import business.services.util.Command;
import business.services.util.ConsoleIO;

public class KeyboardController implements Controller {
	
	private Player<Track> mp3Player;
	
	public KeyboardController() {
		mp3Player = new MP3Player();
	}
	
	@Override
	public void start() {
		
		String userInput;
		boolean exitWanted;
		
		ConsoleIO.printMenu();
		
		do {
			userInput = ConsoleIO.askForUserInput();
			interpretUserInput(userInput);
			exitWanted = Command.QUIT.equals(Command.fromString(userInput));
		} while (!exitWanted);
		
	}
	
	private void interpretUserInput(String input) {
		
		final String[] inputWords = input.split(" ");
		final String commandInput = inputWords[0].toLowerCase();
		final Command command = Command.fromString(commandInput);
		
		switch (command) {
			case LOAD:
				performLoadAction(inputWords);
				break;
			case PLAY:
				performPlayAction(inputWords);
				break;
			case PAUSE:
				mp3Player.pause();
				break;
			case REPEAT:
				mp3Player.toggleRepeat();
				break;
			case SHUFFLE:
				mp3Player.toggleShuffle();
				break;
			case SKIP:
				mp3Player.skip();
				break;
			case SKIPBACK:
				mp3Player.skipBack();
				break;
			case STOP:
				mp3Player.stop();
				break;
			case VOLUME:
				performVolumeAdjustment(inputWords);
				break;
			default:
				break;
		}
		
	}
	
	private void performLoadAction(String[] input) {
		if (input.length > 1) {
			final String path = input[1];
			final Playlist playlist = new Playlist(path);
			mp3Player.setPlaylist(playlist);
		}
		
		
	}
	
	private void performPlayAction(String[] input) {
		if (input.length > 1) {
			final String path = input[1]; 
			mp3Player.play(path);
		} else {
			mp3Player.play();
		}
	}
	
	private void performVolumeAdjustment(String[] input) {
		if (input.length > 1) {
			final String valueAsString = input[1];
			final float value = Float.parseFloat(valueAsString);
			mp3Player.volume(value);
		}
	}

}
