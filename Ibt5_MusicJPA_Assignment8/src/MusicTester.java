
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.*;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;


public class MusicTester {

	public static void main(String[] args) {
		GenreManager gm = new GenreManager();
		Genre g = gm.getGenre("082b82f8-fd7c-4324-b051-258ea939c58b");
		 System.out.println(g.toJSON().toString());
		 
		 
		//System.out.println(gm.getGenreList("Blues", "equals"));
			//System.out.println(gm.getGenreList("heavy", "begins"));
			// System.out.println(gm.getGenreList("e2", "ends")); 
		
	
		
		
		
		

		
		
		
		
		
		
	}

}
