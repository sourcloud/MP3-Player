package business.data.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import business.data.Track;

public class M3U_IO {
	
	public static List<Track> importPlaylist(String path) {
		
		List<Track> allTracks = new ArrayList<>();
		
		try (BufferedReader fileReader 
				= new BufferedReader(new FileReader(path))) {
			
			String pathToMP3;
			
			while ((pathToMP3 = fileReader.readLine()) != null) {
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
