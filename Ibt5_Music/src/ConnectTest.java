import java.sql.*;
import java.net.URL;


public class ConnectTest {

	public static void main(String[] args) {
		
		String server = "sis-teach-01.sis.pitt.edu"; 
		String port = "3306";
		String userName = "infsci1017_2019";
		String Password = "infsci1017_2019!";
		String dbName = "music2019";
		
		//Step 1: Define connection string
		
		String mySqlConn = "jdbc:mysql://"+ server + "/" + dbName +"?user="+ userName +"&password="+ Password;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection(mySqlConn);
			
			
			//String sql = "INSERT INTO genre(genre_name,description) VALUES ('Country','dance friendly music');";
			// Statement statement = conn.createStatement();
	        // statement.executeUpdate(sql);
			
			String sql = "SELECT genre_id,genre_name,description FROM genre;";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql); // Return ResultSet\
            
            while (rs.next()) {
            	
            	System.out.println(rs.getInt(1));
            	System.out.println(rs.getString(2));
            	System.out.println(rs.getString(3));
            }
 
			
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
	}

}
