package business.interfaces;

import business.abstracts.Playable;
import business.data.Playlist;

/**
 * Interface that defines a MediaPlayer's behaviour.
 * 
 * @author Sascha Scheid
 *
 * @param <T> Class that extends Playable. Describes
 * which medium the player will play.
 */
public interface MediaPlayer<T extends Playable> {

	/**
	 * Plays the currently loaded playable object.
	 */
	void play();
	
	/**
	 * Loads the playable object and plays it.
	 * @param toPlay Playable object.
	 */
	void play(T toPlay);
	
	/**
	 * Loads the playable object at given path and
	 * plays ist.
	 * @param pathToFile Path to a playable file.
	 */
	void play(String pathToFile);
	
	/**
	 * Interupts playing.
	 */
	void pause();
	
	/*
	 * Interupts playing and rewinds currently loaded
	 * playable object.
	 */
	void stop();
	
	/**
	 * Changes volume to given value.
	 * @param value Value to set volume to.
	 */
	void volume(float value);
	
	/**
	 * Sets a playlist of playable 
	 * @param playlist
	 */
	void setPlaylist(Playlist playlist);
	
	/**
	 * Loads and plays next song on playlist.
	 */
	void skip();
	
	/**
	 * Loads and plays previous song on playlist.
	 */
	void skipBack();
	
	/**
	 * Switches shuffle state.
	 */
	void toggleShuffle();
	
	/**
	 * Switches repeat state.
	 */
	void toggleRepeat();

}
