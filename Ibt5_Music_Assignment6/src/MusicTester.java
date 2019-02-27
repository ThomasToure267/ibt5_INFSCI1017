import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MusicTester {
	
	
	public static void main(String[] args) {
		Connection conn;
		

		String server = "sis-teach-01.sis.pitt.edu"; 
		String port = "3306";
		String userName = "infsci1017_2019";
		String Password = "infsci1017_2019!";
		String dbName = "music2019";
		
		//Step 1: Define connection string
		
		String mySqlConn = "jdbc:mysql://"+ server + "/" + dbName +"?user="+ userName +"&password="+ Password;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(mySqlConn);
			/*
			Artist g1 = new Artist("'0208d02c-191e-4e58-9103-f474b9253581'");
			g1.setFirstName("Tom",conn);
			g1.setLastName("Lara",conn);
			g1.setBandName("heavy e metu",conn);
			g1.setBio("He is a famous Greek-American musician",conn);
			*/
			
			/*
			Song s2 = new Song("'04322ee1-d1d2-4f7c-87c2-8e82266f659e'");
				s2.setTitle("Till the Morning Leaves",conn);
				s2.setLength(3,conn);
				s2.setFilePath("songs/hyena-laugh_daniel-simion.mp3",conn);
				s2.setRecordDate("1969-05-08 00:00:00",conn);
				s2.setReleaseDate("1968-01-08 00:00:00",conn);
			*/
			
			/*
			Artist g4 = new Artist("'0208d02c-191e-4e58-9103-f474b9253581'");
			Song s3 = new Song("'0615a78a-6ba1-466f-a616-5e6b5894cb1b'");
				s3.addArtist(g4,conn);
			*/
			
			/*
			Album a2 = new Album("'015ebcfe-a37b-4e4f-9c3e-48710411e832'");
				a2.setTitle("Blueprint",conn);
				a2.setLength(5,conn);
				a2.setNumberOfTracks(25,conn);
				a2.setCoverImagePath("songs/hyena-laugh_daniel-simion.mp3",conn);
				a2.setPmrcRating("good ratings",conn);
				a2.setRecordingCompany("ROC Boys",conn);
				a2.setReleaseDate("1968-01-08 00:00:00",conn);
				*/
			
			/*
			Song s5 = new Song("'0208d02c-191e-4e58-9103-f474b9253581'");
			Album a2 = new Album("'00b066c1-b308-4902-8416-df37fa295261'");
				a2.addSong(s5,conn);
				
				'036a0465-27cc-47db-b32f-f11f1a992ce8', 'Bob', 'Dylan', 'Bob Dylan', 'Rhythm guitarist, singer/songwriter'

			*/
			
			
			Artist g2 = new Artist("036a0465-27cc-47db-b32f-f11f1a992ce8",conn); 
			System.out.println(g2.getFirstName());
			System.out.println(g2.getLastName());
			System.out.println(g2.getBandName());
			System.out.println(g2.getBio());
			
			
			
			
						
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*
		ArrayList<Artist> artistList = new ArrayList<>();
		Map<String,Artist> artistTable = new HashMap<String,Artist>();
		String sql = "SELECT * FROM artist;";
		DbUtilities db = new DbUtilities();
		try {
			ResultSet rs = db.getResultSet(sql);
			while(rs.next()) {
				
				Artist temp = new Artist(rs.getString("artist_id"));
				artistList.add(temp);
				artistTable.put(rs.getString("artist_id"),temp);
				
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
		for (Artist a :artistList) {
			if (a.getArtistID()== "'0279c548-b564-4230-98bb-2ca46d09e516'") {
				System.out.println(a.getFirstName());
			}
			
		}
		
		System.out.println(artistTable.get("'0279c548-b564-4230-98bb-2ca46d09e516'"));
		
		*/
		

		
		/*
		Song s1 = new Song("'0304f2e8-f12b-4938-9d87-3323c51ee105'");
		
			System.out.println(s1.getTitle());
			System.out.println(s1.getLength());
			System.out.println(s1.getFilePath());
			System.out.println(s1.getRecordDate());
			System.out.println(s1.getTitle());
			System.out.println(s1.getReleaseDate());
			
			System.out.println(s1.getSongArtists());
			
			System.out.println(s1.getSongArtists());
		*/
		
		/*
		Song s2 = new Song("'04322ee1-d1d2-4f7c-87c2-8e82266f659e'");
			s2.setTitle("Till the Morning Leaves");
			s2.setLength(3);
			s2.setFilePath("songs/hyena-laugh_daniel-simion.mp3");
			s2.setRecordDate("1969-05-08 00:00:00");
			s2.setReleaseDate("1968-01-08 00:00:00");
		*/
		
		
		/*
		Song s3 = new Song("'0615a78a-6ba1-466f-a616-5e6b5894cb1b'");
			s3.deleteSong("'0615a78a-6ba1-466f-a616-5e6b5894cb1b'");
			*/
		
	
		
	//	Song s4 = new Song("'acbcd1b9-dcb2-413f-bc1a-598d2943f340'");
		//	s4.deleteArtist("'0437c71f-fee1-4f70-9f9e-ac423be67c56'");
			
		
		/*
		Artist g4 = new Artist("'0208d02c-191e-4e58-9103-f474b9253581'");
		Song s3 = new Song("'0615a78a-6ba1-466f-a616-5e6b5894cb1b'");
			s3.deleteArtist(g4);
		*/
			
		
		
		
		
		
		
		
		
			
		
		/*
		Artist g1 = new Artist("'048dc852-5b0f-4859-823a-46f39f8f611b'");
			g1.deleteArtist("'048dc852-5b0f-4859-823a-46f39f8f611b'");
		*/
		
		
		
		/*
		Album a1 = new Album("'015ebcfe-a37b-4e4f-9c3e-48710411e832'");
		System.out.println(a1.getTitle());
		System.out.println(a1.getLength());
		System.out.println(a1.getNumberOfTracks());
		System.out.println(a1.getCoverImagePath());
		System.out.println(a1.getPmrcRating());
		System.out.println(a1.getRecordingCompany());
		System.out.println(a1.getReleaseDate());
		*/
		
		
			
		/*
		Album a2 = new Album("'00b066c1-b308-4902-8416-df37fa295261'");
			a2.deleteAlbum("'00b066c1-b308-4902-8416-df37fa295261'");
			*/
		
		
	
		
		/*
		Album a2 = new Album("'00b066c1-b308-4902-8416-df37fa295261'");
				a2.deleteSong("'0437c71f-fee1-4f70-9f9e-ac423be67c56'");
		*/
		
		/*
		Song s2 = new Song("'04322ee1-d1d2-4f7c-87c2-8e82266f659e'");
		Album a6 = new Album("'00b066c1-b308-4902-8416-df37fa295261'");
			a6.deleteSong(s2);
		*/
		
		
	}

}
