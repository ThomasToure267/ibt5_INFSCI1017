
import javax.persistence.Entity.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="genre")

public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "genre_id")
	private String genreID;
	
	@Column(name = "genre_name")
	private String genreName;
	
	@Column(name = "description")
	private String description;
	
	
	public Genre() {

		
	}
	
	public void setGenreID(String GenreID) {
		this.genreID = GenreID;
		
	}
	

	
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		
		
		this.genreName = genreName;
		
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		
		this.description = description;
		
	}
	public String getGenreID() {
		return genreID;
	}
	//public JSONObject to JSON() {
//		JSONobject 
//	}
	
	
	
	
}
