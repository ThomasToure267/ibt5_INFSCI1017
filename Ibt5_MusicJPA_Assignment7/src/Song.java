import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;
 
/**
 *Class Song 
 *Provides methods for creating,deleting and updating a database
 * @author Thomas Toure
 * Creates a new song record in the database
Creates a new Song object
Generates a songID using  java.util.UUID.randomUUID() method
Sets corresponding class properties

 */
@Entity
@Table(name="song")




public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "song_id")
	private String songID;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "length")
	private int length;

	@Column(name = "file_path")
	private String filePath;
	
	@Column(name = "release_date")
	private String releaseDate;
	
	@Column(name = "record_date")
	private String recordDate;
	
	@Transient Map<String, Artist> songArtists = new HashMap<String, Artist>();

	public String getSongID() {
		return songID;
	}

	public void setSongID(String songID) {
		this.songID = songID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}

	public Map<String, Artist> getSongArtists() {
		return songArtists;
	}

	public void setSongArtists(Map<String, Artist> songArtists) {
		this.songArtists = songArtists;
	}
	
	
	
	
}
	
