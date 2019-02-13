import java.util.Map;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID; 

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
	private Map<String, Artist> songArtists;
	
	private DbUtilities db;
	
	
	/**
	*
	* @author Thomas Toure
	* Creates a new song record in the database
	* Creates a new Song object
	* Generates a songID using  java.util.UUID.randomUUID() method
	* Sets corresponding class properties

	 */
	public Song(String title,int length,String releaseDate,String recordDate) {
		
		db = new DbUtilities();
		this.title = title;
		this.length = length;
		this.releaseDate = releaseDate;
		this.recordDate = recordDate;
		this.songID= UUID.randomUUID().toString();//Generates a songID using  java.util.UUID.randomUUID() method
		String sql = "INSERT INTO song (title,length,release_date,record_date) VALUES  ('" + title+"', '"+ length+ "','"+releaseDate+"','"+recordDate+"');";//creates a new object record
		System.out.println(sql);
		db.executeQuery(sql);
		

}
	
	/**
	*
	* @author Thomas Toure
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
	
	public void addArtist(Artist artist) {
		db = new DbUtilities();
		
		String sql3 = "INSERT INTO song_artist (fk_song_id,fk_artist_id) VALUES  ('" + this.songID+"', '"+artist.getArtistID()+"');";
		System.out.println(sql3);
		db.executeQuery(sql3);
		
		
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
	public void deleteartist (Artist artist) {
		db = new DbUtilities();
		
		String sql5 = "DELETE FROM song_artist WHERE fk_artist_id= ' "+ artist.getArtistID()+"' AND fk_song_id='"+this.songID+"';";
		System.out.println(sql5);
		db.executeQuery(sql5);
		
	}

	

	public String getTitle() {//Method to get the Title from the database
		return title;
	}
	public void setTitle(String title) {//Method to update the title from the database
		
		
		String sql = "UPDATE song SET title = ' "+title+"'WHERE song_id = "+ this.songID + ";"; 
		this.title = title;
		System.out.println(sql);
		db.executeQuery(sql);
		
		
	}
	
	public String getsongID() {//Method to get the songId from the database
		return songID;
	}
	public int getLength() {//Method to get the length of the song from the database
		return length;
	}
	public void setLength(int length) {//Method to update length of the song from the database
		String sql = "UPDATE song SET length = ' "+length+"'WHERE song_id = "+ this.songID + ";"; 
		this.length = length;
		System.out.println(sql);
		db.executeQuery(sql);
		
		
		
	}
	public String getFilePath() {//Method to get filepath of the song from the database
		return filePath;
	}
	public void setFilePath(String filePath) {//Method to update the filepath of the song from the database
		
		String sql = "UPDATE song SET title = ' "+filePath+"'WHERE song_id = "+ this.songID + ";"; 
		this.filePath = filePath;
		System.out.println(sql);
		db.executeQuery(sql);
		
		
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		
		String sql = "UPDATE song SET title = ' "+releaseDate+"'WHERE song_id = "+ this.songID + ";"; 
		this.releaseDate = releaseDate;
		System.out.println(sql);
		db.executeQuery(sql);
		
		
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		
		String sql = "UPDATE song SET title = ' "+recordDate+"'WHERE song_id = "+ this.songID + ";"; 
		this.recordDate = recordDate;
		System.out.println(sql);
		db.executeQuery(sql);
		
		
	}
	public Map<String, Artist> getSongArtists() {
		return songArtists;
	}
	
	public void setSongArtists(Map<String, Artist> songArtists) {
		
		
		//String sql = "UPDATE song_artist WHERE fk_artist_id  "+ songArtists.getArtistID()+" AND fk_song_id"+songID+";";
	//this.songArtists = songArtists;
	//	System.out.println(sql);
	//	db.executeQuery(sql);
		
	}
	
	
	
	
	
	
}