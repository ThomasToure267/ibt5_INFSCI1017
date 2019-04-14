import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;
/**
*
* @author Thomas Toure
* Retrieves an existing record from the database using songID as the key
* Creates a new song object
* Sets corresponding class properties
 */


@Entity
@Table (name="album")


public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "album_id")
	private String albumID;
	
	@Column (name = "title")
	private String title;
	
	@Column (name = "release_date")
	private String releaseDate;
	
	@Column (name ="cover_image_path")
	private String coverImagePath;
	
	@Column(name = "recording_company_name")
	private String recordingCompany;
	
	@Column(name = "number_of_tracks")
	private int numberOfTracks;
	
	@Column(name ="PMRC_rating")
	private String pmrcRating;
	
	@Column (name = "length")
	private int length;
	
	@Transient
	Map<String,Song>albumSongs = new HashMap<String, Song>();

	public String getAlbumID() {
		return albumID;
	}

	public void setAlbumID(String albumID) {
		this.albumID = albumID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getCoverImagePath() {
		return coverImagePath;
	}

	public void setCoverImagePath(String coverImagePath) {
		this.coverImagePath = coverImagePath;
	}

	public String getRecordingCompany() {
		return recordingCompany;
	}

	public void setRecordingCompany(String recordingCompany) {
		this.recordingCompany = recordingCompany;
	}

	public int getNumberOfTracks() {
		return numberOfTracks;
	}

	public void setNumberOfTracks(int numberOfTracks) {
		this.numberOfTracks = numberOfTracks;
	}

	public String getPmrcRating() {
		return pmrcRating;
	}

	public void setPmrcRating(String pmrcRating) {
		this.pmrcRating = pmrcRating;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Map<String, Song> getAlbumSongs() {
		return albumSongs;
	}

	public void setAlbumSongs(Map<String, Song> albumSongs) {
		this.albumSongs = albumSongs;
	};
	
	

}
