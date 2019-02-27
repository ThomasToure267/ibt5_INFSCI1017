import java.util.UUID;
import java.util.*;

import java.sql.PreparedStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
 
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
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	/**
	*
	* @author Thomas Toure
	* class constructor
	*Retrieves an existing record from the database using artistID as the key
Creates a new Artist object
Sets corresponding class properties

	 */

public Artist(String firstName,String lastName,String bandName, Connection mySqlConn) {
	
	
	this.firstName = firstName;
	this.lastName = lastName;
	this.bandName = bandName;
	
	this.artistID= UUID.randomUUID().toString();//Generates an artistID using  java.util.UUID.randomUUID() method
	String sql = "INSERT INTO artist (artist_id,first_name,last_name,band_name) VALUES  (?,?,?,?);";//creates a new object record
	try {
		stmt = mySqlConn.prepareStatement(sql);
		
		stmt.setString(1, artistID);
		stmt.setString(2, firstName);
		stmt.setString(3, lastName);
		stmt.setString(4, bandName);
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
*Retrieves an existing record from the database using artistID as the key
Creates a new Artist object
Sets corresponding class properties

 */
public Artist(String artistID,Connection mySqlConn) {
	
	this.artistID =artistID;
	
	
	String sql1 = "SELECT first_name,last_name,band_name,bio from artist WHERE artist_id = ?";//Retrieves an existing record from the database using artist_ID as the key

	try {
		
		
		stmt = mySqlConn.prepareStatement(sql1);
		
		stmt.setString(1,artistID);
		
		rs = stmt.executeQuery();

		while (rs.next()) {
			this.firstName = rs.getString("first_name");
			this.lastName = rs.getString("last_name");
			this.bandName = rs.getString("band_name");
			this.bio = rs.getString("bio");
		}
		
		
	
	}
	catch (SQLException e) {
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
public void deleteArtist(String artistID, Connection mySqlConn) {
	this.artistID = artistID;
	db = new DbUtilities();
	String sql2 = "DELETE FROM artist WHERE artist_id = ?";//Deletes an artist from the database using artistID as the key
try {
		
		stmt = mySqlConn.prepareStatement(sql2);
		stmt.setString(1, artistID);
		
		System.out.println(stmt);
		int i = stmt.executeUpdate();
		System.out.println("Deleted record got inserted");
	}
	catch (SQLException e) {
	e.printStackTrace();	
		
	}
}


public String getArtistID() {
	return artistID;
}





public String getFirstName() {
	
	return firstName;
}


public void setFirstName(String firstName, Connection mySqlConn) {
	String sql = "UPDATE artist SET first_name = ? WHERE artist_id = ?"; 
	try {
		stmt = mySqlConn.prepareStatement(sql);
		stmt.setString(1, firstName);
		stmt.setString(2,this.artistID);
		System.out.println(stmt);
		int i = stmt.executeUpdate();
		System.out.println("new record got inserted");
		
	}
	catch (SQLException e) {
		e.printStackTrace();	
			
		}
	
	
	
	
}


public String getLastName() {
	return lastName;
}


public void setLastName(String lastName, Connection mySqlConn) {
	
	String sql = "UPDATE artist SET last_name = ? WHERE artist_id = ?"; 
	
	try {
		stmt = mySqlConn.prepareStatement(sql);
		stmt.setString(1, lastName);
		stmt.setString(2,this.artistID);
		System.out.println(stmt);
		int i = stmt.executeUpdate();
		System.out.println("new record got inserted");
		
	}
	catch (SQLException e) {
		e.printStackTrace();	
			
		}
	
	
	
}


public String getBandName() {
	return bandName;
}


public void setBandName(String bandName, Connection mySqlConn) {
	
	String sql = "UPDATE artist SET band_name = ? WHERE artist_id = ?"; 
try {
		
		stmt = mySqlConn.prepareStatement(sql);
		stmt.setString(1, bandName);
		stmt.setString(2,this.artistID);
		System.out.println(stmt);
		int i = stmt.executeUpdate();
		System.out.println("new record got inserted");
	}
	catch (SQLException e) {
	e.printStackTrace();	
		
	}
	
}


public String getBio() {
	return bio;
}


public void setBio(String bio,Connection mySqlConn) {
	
	String sql = "UPDATE artist SET bio = ? WHERE artist_id = ?"; 
try {
		
		stmt = mySqlConn.prepareStatement(sql);
		stmt.setString(1, bandName);
		stmt.setString(2,this.artistID);
		System.out.println(stmt);
		int i = stmt.executeUpdate();
		System.out.println("new record got inserted");
	}
	catch (SQLException e) {
	e.printStackTrace();	
		
	}
	
}



}