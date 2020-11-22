package business.interfaces;

import business.data.Playlist;

public interface Player<T> {

	// normal functionality
	
	void play();
	void play(T toPlay);
	void play(String pathToFile);
	void pause();
	void stop();
	void volume(float value);
	
	// playlist functionality
	
	void setPlaylist(Playlist playlist);
	void skip();
	void skipBack();
	void toggleShuffle();
	void toggleRepeat();
	
}
