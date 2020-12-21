package business.data.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import business.data.Track;

public class M3U_IO {
	
	public static List<Track> importPlaylist(String path) {
		return importPlaylist(new File(path));
	}
	
	public static List<Track> importPlaylist(File file) {
		
		List<Track> allTracks = new ArrayList<>();
		
		try (BufferedReader reader 
				= new BufferedReader(new FileReader(file))) {
			
			String pathToMP3;
			
			while ((pathToMP3 = reader.readLine()) != null) {
				Track nextTrack = new Track(pathToMP3);
				allTracks.add(nextTrack);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return allTracks;
		
	}
	
	public static void exportPlaylist() {
		
	}

}
