import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import java.sql.PreparedStatement;

import java.sql.*;

/**
 *Class Song 
 *Provides methods for creating,deleting and updating a database
 * @author Thomas Toure
 * Creates a new song record in the database
Creates a new Song object
Generates a songID using  java.util.UUID.randomUUID() method
Sets corresponding class properties

 */





public class Song {
	
	private String songID;
	private String title;
	private int length;
	private String filePath;
	private String releaseDate;
	private String recordDate;
	private Connection conn;
	private PreparedStatement stmt;
	 Map<String, Artist> songArtists = new HashMap<String, Artist>();
	
	private DbUtilities db;
	
	
	/**
	*
	* @author Thomas Toure
	* class constructor
	* Creates a new song record in the database
	* Creates a new Song object
	* Generates a songID using  java.util.UUID.randomUUID() method
	* Sets corresponding class properties

	 */
	public Song(String title,int length,String releaseDate,String recordDate,Connection conn) {
		
		
		this.conn = conn;
		this.title = title;
		this.length = length;
		this.releaseDate = releaseDate;
		this.recordDate = recordDate;
		this.songID= UUID.randomUUID().toString();//Generates a songID using  java.util.UUID.randomUUID() method
		String sql = "INSERT INTO song (song_id,title,length,release_date,record_date) VALUES  (?,?,?,?,?);";//creates a new object record
		//System.out.println(sql);
		//db.executeQuery(sql);
		try {
			
			stmt =conn.prepareStatement(sql);
			stmt.setString(1, songID);
			stmt.setString(2, title);
			stmt.setInt(3, length);
			stmt.setString(4, releaseDate);
			stmt.setString(5,recordDate);
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
	* class constructor
	* Retrieves an existing record from the database using songID as the key
	* Creates a new song object
	* Sets corresponding class properties
	 */
	public Song(String songID) {//class constructor

		
		this.songID = songID;
		db = new DbUtilities();
		String sql1 = "SELECT title,length,release_date,record_date from song WHERE song_id = "+ this.songID+";";//Retrieves an existing record from the database using songID as the key

	try {//creates a new song object
			
			ResultSet rs = db.getResultSet(sql1);
			
			if(rs.next()) {
				
				this.title = rs.getString("title");
				this.length = rs.getInt("length");
				this.releaseDate = rs.getString("release_date");
				this.recordDate = rs.getString("record_date");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	/**
	*
	* @author Thomas Toure
	* Deletes a song from the database using songID as the key
	* Note that when this method is called, the corresponding object needs to be destroyed!
	 */
	public void deleteSong(String songID) {

		this.songID = songID;
		db = new DbUtilities();
		String sql2 = "DELETE FROM song WHERE song_id = "+ this.songID+";";//Query to deletes a song from the database using songID as the key
		System.out.println(sql2);
		db.executeQuery(sql2);
		
		
		
	
		
		
	}
	/**
	*
	* @author Thomas Toure
	* adds new song object to the list of the song's artist
	 */
	
	public void addArtist(Artist artist,Connection mySqlConn) {
		
		
		String sql3 = "INSERT INTO song_artist (fk_song_id,fk_artist_id) VALUES  (?,?);";
		try {
		stmt = mySqlConn.prepareStatement(sql3);
		songArtists.put(artist.getArtistID(),artist);
		stmt.setString(1, this.songID);
		stmt.setString(2, artist.getArtistID());
		System.out.println(stmt);

		System.out.println("new Artist got inserted");
		
		
		}
		

		catch (SQLException e) {
		e.printStackTrace();	
			
		}
		
		
	}
	/**
	*
	* @author Thomas Toure
	* Deletes an artist from the list of the song’s artists by artistID
	 */
	
	public void deleteArtist(String aristID) {
		db = new DbUtilities();
		String sql4 = "DELETE FROM song_artist WHERE fk_artist_id = "+ aristID+" AND fk_song_id="+this.songID+";";
		System.out.println(sql4);
		db.executeQuery(sql4);
		
	}
	
	
	/**
	*
	* @author Thomas Toure
	* Deletes an artist from the list of the song’s artists by artistID property of the Artist object
	 */
	public void deleteArtist (Artist artist) {
		db = new DbUtilities();
		
		String sql5 = "DELETE FROM song_artist WHERE fk_artist_id=  "+ artist.getArtistID()+" AND fk_song_id="+this.songID+";";
		System.out.println(sql5);
		db.executeQuery(sql5);
		
	}

	

	public String getTitle() {//Method to get the Title from the database
		return title;
	}
	public void setTitle(String title,Connection mySqlConn) {//Method to update the title from the database
		
		
		String sql = "UPDATE song SET title =  ? WHERE song_id = ? "; 
		try {
			stmt = mySqlConn.prepareStatement(sql);
			stmt.setString(1, title);
			stmt.setString(2,this.songID);
			System.out.println(stmt);
			int i = stmt.executeUpdate();
			System.out.println("new record got inserted");
			
		}
		catch (SQLException e) {
			e.printStackTrace();	
				
			}
		
		
	}
	
	public String getsongID() {//Method to get the songId from the database
		return songID;
	}
	public int getLength() {//Method to get the length of the song from the database
		return length;
	}
	public void setLength(int length,Connection mySqlConn) {//Method to update length of the song from the database
		String sql = "UPDATE song SET length = ? WHERE song_id = ? "; 
		try {
			stmt = mySqlConn.prepareStatement(sql);
			stmt.setInt(1, length);
			stmt.setString(2,this.songID);
			System.out.println(stmt);
			int i = stmt.executeUpdate();
			System.out.println("new Length got inserted");
			
		}
		catch (SQLException e) {
			e.printStackTrace();	
				
			}
		
		
		
	}
	public String getFilePath() {//Method to get filepath of the song from the database
		return filePath;
	}
	public void setFilePath(String filePath,Connection mySqlConn) {//Method to update the filepath of the song from the database
		
		String sql = "UPDATE song SET title = ? WHERE song_id = ? "; 
		try {
			stmt = mySqlConn.prepareStatement(sql);
			stmt.setString(1, filePath);
			stmt.setString(2,this.songID);
			System.out.println(stmt);
			int i = stmt.executeUpdate();
			System.out.println("new File path got inserted");
			
		}
		catch (SQLException e) {
			e.printStackTrace();	
				
			}
		
		
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate,Connection mySqlConn) {
		
		String sql = "UPDATE song SET title = ? WHERE song_id = ? "; 
		try {
			stmt = mySqlConn.prepareStatement(sql);
			stmt.setString(1, releaseDate);
			stmt.setString(2,this.songID);
			System.out.println(stmt);
			int i = stmt.executeUpdate();
			System.out.println("new release date got inserted");
			
		}
		catch (SQLException e) {
			e.printStackTrace();	
				
			}
		
		
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate,Connection mySqlConn) {
		
		String sql = "UPDATE song SET title = ? WHERE song_id = ? "; 
		try {
			stmt = mySqlConn.prepareStatement(sql);
			stmt.setString(1, recordDate);
			stmt.setString(2,this.songID);
			System.out.println(stmt);
			int i = stmt.executeUpdate();
			System.out.println("new record date got inserted");
			
		}
		catch (SQLException e) {
			e.printStackTrace();	
				
			}
		
		
	}
	/*
	public void setSongArtists1(Map <String,Artist> songArtists) {
		Set keys = songArtists.keySet();
		Iterator itr = keys.iterator();
		
		String key;
		String value;
		
		while (itr.hasNext())
		{
			key = (String) itr.next();
			value = 
			Artist a = new Artist(key, con);
			songArtists.put(key,a);
			
		}
		*/
		
		
	
	
	//public String getSongArtists() {
		
		//iterate through hashmap
		
		
	//	return Artist;
		
		
	
		
	//}
	
	
	
	
	
	
}