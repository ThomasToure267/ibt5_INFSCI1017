import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;
/**
*
* @author Thomas Toure
* Retrieves an existing record from the database using songID as the key
* Creates a new song object
* Sets corresponding class properties
 */
public class Album {

	private String albumID;
	private String title;
	private String releaseDate;
	private String coverImagePath;
	private String recordingCompany;
	private int numberOfTracks;
	private String pmrcRating;
	private int length;
	private Map<String,Song>albumSongs;
	private DbUtilities db;
	
	
	
	/**
	*
	* @author Thomas Toure
	* class constructor
Creates a new album record in the database
Creates a new Album object
Generates a albumID using  java.util.UUID.randomUUID() method
Sets corresponding class properties

	 */
public Album(String title,String releaseDate,String recordingCompany,int numberOfTracks,String pmrcRating,int length) {
		
	db = new DbUtilities();
	this.title = title;
	this.releaseDate = releaseDate;
	this.recordingCompany = recordingCompany;
	this.numberOfTracks =numberOfTracks;
	this.pmrcRating=pmrcRating;
	this.length = length;
	this.albumID= UUID.randomUUID().toString();//Generates an artistID using  java.util.UUID.randomUUID() method
	String sql = "INSERT INTO album (title,release_date,recording_company_name,number_of_tracks,PMRC_rating,length) VALUES  ('" + title+"', '"+ releaseDate+ "','"+recordingCompany+"','"+numberOfTracks+"','"+pmrcRating+"','"+length+"');";//creates a new object record
	System.out.println(sql);
	db.executeQuery(sql);
	
	}
/**
*
* @author Thomas Toure
*Retrieves an existing record from the database using album as the key
Creates a new Album object
Sets corresponding class properties

 */
public Album(String albumID) {

	this.albumID = albumID;
	db = new DbUtilities();
	String sql1 = "SELECT title,release_date,recording_company_name,number_of_tracks,PMRC_rating,length from album WHERE album_id = "+ this.albumID+";";//Retrieves an existing record from the database using songID as the key

try {//creates a new song object
		
		ResultSet rs = db.getResultSet(sql1);
		
		if(rs.next()) {
			
			this.title = rs.getString("title");
			this.releaseDate = rs.getString("release_date");
			this.recordingCompany = rs.getString("recording_company_name");
			this.numberOfTracks = rs.getInt("number_of_tracks");
			this.pmrcRating = rs.getString("PMRC_rating");
			this.length = rs.getInt("length");
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	

}
/**
*
* @author Thomas Toure
* Deletes an album from the database using albumID as the key
Note that when this method is called, the corresponding object needs to be destroyed!

 */

public void deleteAlbum(String albumID) {
	
	
	this.albumID = albumID;
	db = new DbUtilities();
	String sql2 = "DELETE FROM album WHERE album_id = "+ this.albumID+";";//Deletes a song from the database using songID as the key
	System.out.println(sql2);
	db.executeQuery(sql2);

	
}
/**
*
* @author Thomas Toure
* Adds new Song object to the list of the album’s songs
 */
public void addSong(Song song) {
	
	
	db = new DbUtilities();
	
	String sql3 = "INSERT INTO album_song (fk_album_id,fk_song_id) VALUES  ('" + this.albumID+"', '"+song.getsongID()+"');";
	System.out.println(sql3);
	db.executeQuery(sql3);
	
	
}
/**
*
* @author Thomas Toure
* Deletes a song from the list of the album’s songs by songID
 */

public void deleteSong(String songID) {
	
	
	db = new DbUtilities();
	String sql4 = "DELETE FROM album_song WHERE fk_album_id = "+ this.albumID+" AND fk_song_id"+songID+";";
	System.out.println(sql4);
	db.executeQuery(sql4);
	
}
/**
*
* @author Thomas Toure
* Deletes a song from the list of the album’s songs by songID property of the corresponding Song object
 */
public void deleteSong(Song song) {
	
	
	db = new DbUtilities();
	String sql5 = "DELETE FROM album_song WHERE fk_song_id  "+ song.getsongID()+" AND fk_album_id"+this.albumID+";";
	System.out.println(sql5);
	db.executeQuery(sql5);
	
}
public String getAlbumID() {
	return albumID;
}

public String getTitle() {
	return title;
}
public void setTitle(String title) {
	
	String sql = "UPDATE album SET title = ' "+title+"'WHERE album_id = "+ this.albumID + ";"; 
	this.title = title;
	System.out.println(sql);
	db.executeQuery(sql);
	
	
}
public String getReleaseDate() {
	return releaseDate;
}
public void setReleaseDate(String releaseDate) {
	
	String sql = "UPDATE album SET release_date = ' "+releaseDate+"'WHERE album_id = "+ this.albumID + ";"; 
	this.releaseDate = releaseDate;
	System.out.println(sql);
	db.executeQuery(sql);
	
	
	
}
public String getCoverImagePath() {
	return coverImagePath;
}
public void setCoverImagePath(String coverImagePath) {
	
	String sql = "UPDATE album SET cover_image_path = ' "+coverImagePath+"'WHERE album_id = "+ this.albumID + ";"; 
	this.coverImagePath = coverImagePath;
	System.out.println(sql);
	db.executeQuery(sql);
	
	
	
}
public String getRecordingCompany() {
	return recordingCompany;
}
public void setRecordingCompany(String recordingCompany) {
	
	
	String sql = "UPDATE album SET recording_company_name = ' "+recordingCompany+"'WHERE album_id = "+ this.albumID + ";"; 
	this.recordingCompany = recordingCompany;
	System.out.println(sql);
	db.executeQuery(sql);
	
}
public int getNumberOfTracks() {
	return numberOfTracks;
}
public void setNumberOfTracks(int numberOfTracks) {
	
	String sql = "UPDATE album SET number_of_tracks = ' "+numberOfTracks+"'WHERE album_id = "+ this.albumID + ";"; 
	this.numberOfTracks = numberOfTracks;
	System.out.println(sql);
	db.executeQuery(sql);
	
	
}
public String getPmrcRating() {
	return pmrcRating;
}
public void setPmrcRating(String pmrcRating) {
	
	String sql = "UPDATE album SET PMRC_rating = ' "+pmrcRating+"'WHERE album_id = "+ this.albumID + ";"; 
	this.pmrcRating = pmrcRating;
	System.out.println(sql);
	db.executeQuery(sql);
	
	
	
}
public int getLength() {
	return length;
}
public void setLength(int length) {
	String sql = "UPDATE album SET length = ' "+length+"'WHERE album_id = "+ this.albumID + ";"; 
	this.length = length;
	System.out.println(sql);
	db.executeQuery(sql);
	
	
	
}
public Map<String, Song> getAlbumSongs() {
	return albumSongs;
}
public void setAlbumSongs(Map<String, Song> albumSongs) {
	this.albumSongs = albumSongs;
}



}
