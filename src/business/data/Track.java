package business.data;

import java.io.IOException;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import business.abstracts.Playable;

public class Track extends Playable {
	
	private String title;
	private String artist;
	private String album;
	private int length;

	public Track(String pathToMP3) {
		super(pathToMP3);
		extractMetadata(pathToMP3);
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public String getAlbum() {
		return album;
	}
	
	public int getLength() {
		return length;
	}

	private void extractMetadata(String pathToMP3){

		Mp3File file;
		try {
			file = new Mp3File(pathToMP3);
			title = file.getId3v1Tag().getTitle();
			artist = file.getId3v1Tag().getArtist();
			album = file.getId3v1Tag().getAlbum();
			length = (int) file.getLength();
		} catch (UnsupportedTagException | InvalidDataException | IOException e) {
			e.printStackTrace();
		}
	}
}
