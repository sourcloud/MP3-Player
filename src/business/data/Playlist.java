package business.data;

import java.util.ArrayList;
import java.util.List;

import business.data.util.M3U_IO;
import business.interfaces.Cycle;
import business.services.util.MathUtil;

public class Playlist implements Cycle<Track> {
	
	private List<Track> tracklist;
	private int currentIndex = 0;
	
	public Playlist() {
		tracklist = new ArrayList<Track>();
	}
	
	public Playlist(String pathToM3U) {
		tracklist = M3U_IO.importPlaylist(pathToM3U);
	}
	
	public static Playlist importPlaylist(String pathToM3U) {
		return new Playlist(pathToM3U);
	}
	
	public List<Track> getTracklist() {
		return tracklist;
	}
	
	public Track random() {
		currentIndex = MathUtil.getRandomInRange(0, tracklist.size() - 1);
		return tracklist.get(currentIndex);
	}
	
	@Override
	public boolean hasNext() {
		return currentIndex < tracklist.size() - 1;
	}

	@Override
	public boolean hasPrev() {
		return currentIndex > 0;
	}
	
	@Override
	public Track current() {
		return tracklist.get(currentIndex);
	}

	@Override
	public Track next() {
		currentIndex = hasNext() ? (currentIndex + 1) : 0;
		return current();
	}

	@Override
	public Track prev() {
		currentIndex = hasPrev() ? (currentIndex - 1) : (tracklist.size() - 1);
		return current();
	}
	
}
