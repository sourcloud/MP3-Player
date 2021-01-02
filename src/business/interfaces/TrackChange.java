package business.interfaces;

import business.abstracts.MusicPlayer;

public interface TrackChange {
	
	public void skip(MusicPlayer player);
	public void skipBack(MusicPlayer player);

}
