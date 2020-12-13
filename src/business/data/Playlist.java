package business.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import business.data.util.M3U_IO;
import business.interfaces.Cycle;
import business.services.util.MathUtil;

public class Playlist implements Cycle<Track> {
	
	private List<Track> tracklist;
	private String name;
	private int currentIndex = 0;
	
	public Playlist() {
		tracklist = new ArrayList<Track>();
	}
	
	public Playlist(String pathToM3U) {
		String[] nameParts = pathToM3U.split("/");
		String lastPart = nameParts[nameParts.length-1];
		name = lastPart;
		tracklist = M3U_IO.importPlaylist(pathToM3U);
	}
	
	public Playlist(File file) {
		String[] nameParts = file.getAbsolutePath().split("/");
		String lastPart = nameParts[nameParts.length-1];
		name = lastPart;
		tracklist = M3U_IO.importPlaylist(file);
	}
	
	public static Playlist importPlaylist(String pathToM3U) {
		return new Playlist(pathToM3U);
	}
	
	public String getName() {
		return name;
	}
	
	public List<Track> getTracklist() {
		return tracklist;
	}
	
	public synchronized Track random() {
		currentIndex = MathUtil.getRandomInRange(0, tracklist.size() - 1);
		return tracklist.get(currentIndex);
	}
	
	@Override
	public synchronized boolean hasNext() {
		return currentIndex < tracklist.size() - 1;
	}

	@Override
	public synchronized boolean hasPrev() {
		return currentIndex > 0;
	}
	
	@Override
	public synchronized Track current() {
		return tracklist.get(currentIndex);
	}

	@Override
	public synchronized Track next() {
		currentIndex = hasNext() ? (currentIndex + 1) : 0;
		return current();
	}

	@Override
	public synchronized Track prev() {
		currentIndex = hasPrev() ? (currentIndex - 1) : (tracklist.size() - 1);
		return current();
	}
	
}
