package business.data;

import java.io.IOException;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import business.abstracts.Playable;

public class Track extends Playable {
	
	private static final String DEFAULT_TITLE = "unknown";
	private static final String DEFAULT_ARTIST = "unknown";
	private static final String DEFAULT_ALBUM = "unknown";
	
	private String title;
	private String artist;
	private String album;
	private byte[] cover;
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
	
	public byte[] getCover() {
		return cover;
	}
	
	public int getLength() {
		return length;
	}

	private void extractMetadata(String pathToMP3){

			try {			
				Mp3File mp3File = new Mp3File("SomeMp3File.mp3");
				setMetadataFromFile(mp3File);			
			} catch (UnsupportedTagException | InvalidDataException | IOException e) {			
				e.printStackTrace();
			}
	}
	
	private void setMetadataFromFile(Mp3File mp3File) {
		
		boolean hasV2Tag = mp3File.hasId3v2Tag();
		boolean hasV1Tag = mp3File.hasId3v1Tag();
		
		if (hasV2Tag)
			setMetadataFromID3v2(mp3File);	
			
		else if (hasV1Tag)	
			setMetadataFromID3v1(mp3File);
			
		else
			setMetadataToDefault();
		
		length = (int) mp3File.getLengthInSeconds();
	}
	
	private void setMetadataFromID3v1(Mp3File file) {
		
		ID3v1 allTags = file.getId3v1Tag();
		
		artist = allTags.getArtist();
		title = allTags.getTitle();
		album = allTags.getAlbum();
	}
	
	private void setMetadataFromID3v2(Mp3File file) {
		
		ID3v2 allTags = file.getId3v2Tag();
		
		artist = allTags.getArtist();
		title = allTags.getTitle();
		album = allTags.getAlbum();
		cover = allTags.getAlbumImage();
	}
	
	private void setMetadataToDefault() {
		artist = DEFAULT_ARTIST;
		title = DEFAULT_TITLE;
		album = DEFAULT_ALBUM;
	}
}
