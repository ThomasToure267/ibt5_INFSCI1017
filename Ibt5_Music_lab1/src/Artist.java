import java.util.UUID;
import java.sql.ResultSet;
import java.sql.SQLException;
 
/**
*
* @author Thomas Toure
* 

 */

public class Artist {
	
	private String artistID;	
	private String firstName;
	private String lastName;
	private String bandName;
	private String  bio;
	private DbUtilities db;

	/**
	*
	* @author Thomas Toure
	* class constructor
	*Retrieves an existing record from the database using artistID as the key
Creates a new Artist object
Sets corresponding class properties

	 */

public Artist(String firstName,String lastName,String bandName) {
	

	db = new DbUtilities();
	this.firstName = firstName;
	this.lastName = lastName;
	this.bandName = bandName;
	
	this.artistID= UUID.randomUUID().toString();//Generates an artistID using  java.util.UUID.randomUUID() method
	String sql = "INSERT INTO artist (first_name,last_name,band_name) VALUES  ('" + firstName+"', '"+ lastName+ "','"+bandName+"');";//creates a new object record
	System.out.println(sql);
	db.executeQuery(sql);
	
	
}

/**
*
* @author Thomas Toure
* class constructor
*Retrieves an existing record from the database using artistID as the key
Creates a new Artist object
Sets corresponding class properties

 */
public Artist(String artistID) {
	

	this.artistID = artistID;
	db = new DbUtilities();
	String sql1 = "SELECT first_name,last_name,band_name from artist WHERE artist_id = "+ this.artistID+";";//Retrieves an existing record from the database using artist_ID as the key

	try {//creates a new song object
		
		ResultSet rs = db.getResultSet(sql1);
		
		while(rs.next()) {
			
			this.firstName = rs.getString("first_name");
			this.lastName = rs.getString("last_name");
			this.bandName = rs.getString("band_name");
			
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}
/**
*
* @author Thomas Toure
* Retrieves an existing record from the database using songID as the key
* Creates a new song object
* Sets corresponding class properties
 */
public void deleteArtist(String artistID) {
	this.artistID = artistID;
	db = new DbUtilities();
	String sql2 = "DELETE FROM artist WHERE artist_id = "+ this.artistID+";";//Deletes an artist from the database using artistID as the key
	System.out.println(sql2);
	db.executeQuery(sql2);
	
}


public String getArtistID() {
	return artistID;
}





public String getFirstName() {
	return firstName;
}


public void setFirstName(String firstName) {
	String sql = "UPDATE artist SET first_name = ' "+firstName+"'WHERE artist_id = "+ this.artistID + ";"; 
	this.firstName = firstName;
	System.out.println(sql);
	db.executeQuery(sql);
	
	
	
	
	
}


public String getLastName() {
	return lastName;
}


public void setLastName(String lastName) {
	
	String sql = "UPDATE artist SET last_name = ' "+lastName+"'WHERE artist_id = "+ this.artistID + ";"; 
	this.lastName = lastName;
	System.out.println(sql);
	db.executeQuery(sql);
	
	
	
}


public String getBandName() {
	return bandName;
}


public void setBandName(String bandName) {
	
	String sql = "UPDATE artist SET band_name = ' "+bandName+"'WHERE artist_id = "+ this.artistID + ";"; 
	this.bandName = bandName;
	System.out.println(sql);
	db.executeQuery(sql);
	
}


public String getBio() {
	return bio;
}


public void setBio(String bio) {
	
	String sql = "UPDATE artist SET bio = ' "+bio+"'WHERE artist_id = "+ this.artistID + ";"; 
	this.bio = bio;
	System.out.println(sql);
	db.executeQuery(sql);
	
}



}