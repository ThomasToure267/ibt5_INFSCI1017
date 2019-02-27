import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MusicTester {
	
	
	public static void main(String[] args) {
		
		GenreManager gm = new GenreManager();
		gm.createGenre(21, "Test", "Some description");
		
	}

}
