import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.sql.*;
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
	private PreparedStatement stmt;
	private Connection conn;
	Map<String,Song>albumSongs = new HashMap<String, Song>();;
	private ResultSet rs;
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
public Album(String title,String releaseDate,String recordingCompany,int numberOfTracks,String pmrcRating,int length, Connection mySqlConn) {
		
	db = new DbUtilities();
	this.title = title;
	this.releaseDate = releaseDate;
	this.recordingCompany = recordingCompany;
	this.numberOfTracks =numberOfTracks;
	this.pmrcRating=pmrcRating;
	this.length = length;
	this.albumID= UUID.randomUUID().toString();//Generates an artistID using  java.util.UUID.randomUUID() method
	String sql = "INSERT INTO album (album_id,title,release_date,recording_company_name,number_of_tracks,PMRC_rating,length) VALUES  (?,?,?,?,?,?,?);";//creates a new object record
try {
		
	stmt = mySqlConn.prepareStatement(sql);
		stmt.setString(1, albumID);
		stmt.setString(2, title);
		stmt.setString(3, releaseDate);
		stmt.setString(4, recordingCompany);
		stmt.setInt(5,numberOfTracks );
		stmt.setString(6,pmrcRating );
		stmt.setInt(7,length );
		int i = stmt.executeUpdate();
		System.out.println(i+" records got inserted");
	}
	catch (SQLException e) {
	e.printStackTrace();	
		
	}
	
	}
/**
*
* @author Thomas Toure
*Retrieves an existing record from the database using album as the key
Creates a new Album object
Sets corresponding class properties

 */
public Album(String albumID, Connection mySqlConn) {

	this.albumID = albumID;
	db = new DbUtilities();
	String sql1 = "SELECT title,release_date,recording_company_name,number_of_tracks,PMRC_rating,length from album WHERE album_id = ?";//Retrieves an existing record from the database using songID as the key


try {
	
	
	stmt = mySqlConn.prepareStatement(sql1);
	
	stmt.setString(1,albumID);
	
	rs = stmt.executeQuery();

	while (rs.next()) {
		this.title = rs.getString("title");
		this.releaseDate = rs.getString("release_date");
		this.recordingCompany = rs.getString("recording_company_name");
		this.numberOfTracks = rs.getInt("number_of_tracks");
		this.pmrcRating = rs.getString("PMRC_rating");
		this.length = rs.getInt("length");
	}
	
	

}
catch (SQLException e) {
e.printStackTrace();	
	
}
	
	

}
/**
*
* @author Thomas Toure
* Deletes an album from the database using albumID as the key
Note that when this method is called, the corresponding object needs to be destroyed!

 */

public void deleteAlbum(String albumID,Connection mySqlConn ) {
	
	
	this.albumID = albumID;
	db = new DbUtilities();
	String sql2 = "DELETE FROM album WHERE album_id = ?";//Deletes a song from the database using songID as the key
	try {
		
		stmt = mySqlConn.prepareStatement(sql2);
		stmt.setString(1, albumID);
		
		System.out.println(stmt);
		int i = stmt.executeUpdate();
		System.out.println("Deleted song ");
	}
	catch (SQLException e) {
	e.printStackTrace();	
		
	}
	
}
/**
*
* @author Thomas Toure
* Adds new Song object to the list of the album’s songs
 */
public void addSong(Song song,Connection mySqlConn) {
	
	
	db = new DbUtilities();
	
	String sql3 = "INSERT INTO album_song (fk_album_id,fk_song_id) VALUES  (?,?);";
	try {
		stmt = mySqlConn.prepareStatement(sql3);
		albumSongs.put(song.getsongID(),song);//implements the Map by adding a song to the map albumSongs.
		stmt.setString(1, this.albumID);
		stmt.setString(2, song.getsongID());
		System.out.println(stmt);

		System.out.println("new Song got inserted");
		
		
		}
		

		catch (SQLException e) {
		e.printStackTrace();	
			
		}
	
	
}
/**
*
* @author Thomas Toure
* Deletes a song from the list of the album’s songs by songID
 */

public void deleteSong(String songID,Connection mySqlConn) {
	
	
	db = new DbUtilities();
	String sql4 = "DELETE FROM album_song WHERE fk_album_id = ? AND fk_song_id=?";
	try {
		
		stmt = mySqlConn.prepareStatement(sql4);
		stmt.setString(1, this.albumID);
		//stmt.setString(2, songID.getsongID());
		
		System.out.println(stmt);
		int i = stmt.executeUpdate();
		System.out.println("Deleted song ");
	}
	catch (SQLException e) {
	e.printStackTrace();	
		
	}
	
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
public void setTitle(String title,Connection mySqlConn) {
	
	String sql = "UPDATE album SET title = ? WHERE album_id = ?"; 
	
	try {
		stmt = mySqlConn.prepareStatement(sql);
		stmt.setString(1, title);
		stmt.setString(2,this.albumID);
		System.out.println(stmt);
		int i = stmt.executeUpdate();
		System.out.println("new title got inserted");
		
	}
	catch (SQLException e) {
		e.printStackTrace();	
			
		}
	
	
	
}
public String getReleaseDate() {
	return releaseDate;
}
public void setReleaseDate(String releaseDate,Connection mySqlConn) {
	
	String sql = "UPDATE album SET release_date = ? WHERE album_id = ? "; 
	try {
		stmt = mySqlConn.prepareStatement(sql);
		stmt.setString(1, releaseDate);
		stmt.setString(2,this.albumID);
		System.out.println(stmt);
		int i = stmt.executeUpdate();
		System.out.println("new Release date got inserted");
		
	}
	catch (SQLException e) {
		e.printStackTrace();	
			
		}
	
	
}
public String getCoverImagePath() {
	return coverImagePath;
}
public void setCoverImagePath(String coverImagePath,Connection mySqlConn) {
	
	String sql = "UPDATE album SET cover_image_path = ? WHERE album_id = ? "; 
	try {
		stmt = mySqlConn.prepareStatement(sql);
		stmt.setString(1,coverImagePath);
		stmt.setString(2,this.albumID);
		System.out.println(stmt);
		int i = stmt.executeUpdate();
		System.out.println("new Cover inage path got inserted");
		
	}
	catch (SQLException e) {
		e.printStackTrace();	
			
		}
	
	
	
}
public String getRecordingCompany() {
	return recordingCompany;
}
public void setRecordingCompany(String recordingCompany,Connection mySqlConn) {
	
	
	String sql = "UPDATE album SET recording_company_name = ? WHERE album_id = ? "; 
	try {
		stmt = mySqlConn.prepareStatement(sql);
		stmt.setString(1,recordingCompany);
		stmt.setString(2,this.albumID);
		System.out.println(stmt);
		int i = stmt.executeUpdate();
		System.out.println("new recording company got inserted");
		
	}
	catch (SQLException e) {
		e.printStackTrace();	
			
		}
	
}
public int getNumberOfTracks() {
	return numberOfTracks;
}
public void setNumberOfTracks(int numberOfTracks,Connection mySqlConn) {
	
	String sql = "UPDATE album SET number_of_tracks = ? WHERE album_id = ? "; 
	try {
		stmt = mySqlConn.prepareStatement(sql);
		stmt.setInt(1,numberOfTracks);
		stmt.setString(2,this.albumID);
		System.out.println(stmt);
		int i = stmt.executeUpdate();
		System.out.println("new number of tracks got inserted");
		
	}
	catch (SQLException e) {
		e.printStackTrace();	
			
		}
	
}
public String getPmrcRating() {
	return pmrcRating;
}
public void setPmrcRating(String pmrcRating,Connection mySqlConn) {
	
	String sql = "UPDATE album SET PMRC_rating = ? WHERE album_id = ? "; 
	try {
		stmt = mySqlConn.prepareStatement(sql);
		stmt.setString(1,pmrcRating);
		stmt.setString(2,this.albumID);
		System.out.println(stmt);
		int i = stmt.executeUpdate();
		System.out.println("new Pmrc rating got inserted");
		
	}
	catch (SQLException e) {
		e.printStackTrace();	
			
		}
	
}
public int getLength() {
	return length;
}
public void setLength(int length,Connection mySqlConn) {
	String sql = "UPDATE album SET length = ? WHERE album_id = ? "; 
	try {
		stmt = mySqlConn.prepareStatement(sql);
		stmt.setInt(1,length);
		stmt.setString(2,this.albumID);
		System.out.println(stmt);
		int i = stmt.executeUpdate();
		System.out.println("new length got inserted");
		
	}
	catch (SQLException e) {
		e.printStackTrace();	
			
		}
	
	
	
}
public Map<String, Song> getAlbumSongs() {
	return albumSongs;
}
public void setAlbumSongs(Map<String, Song> albumSongs) {
	this.albumSongs = albumSongs;
}



}
