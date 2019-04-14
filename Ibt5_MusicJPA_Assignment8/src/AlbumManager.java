
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.json.JSONArray;

public class AlbumManager {

	
	public void createAlbum(String albumID,String title, String releaseDate,String coverImagePath,String recordingCompany,int numberOfTracks,String pmrcRating,int length) {
		EntityManagerFactory emFactory = 
				Persistence.createEntityManagerFactory("Ibt5_MusicJPA_Assignement8");
		
		EntityManager em = emFactory.createEntityManager();
		
		em.getTransaction().begin();
		Album al = new Album();
		
		// Artist a = new Artist();
		// a.setArtistID(UUID.randomUUID().toString());
		
		al.setTitle(title);
		al.setReleaseDate(releaseDate);
		al.setCoverImagePath(coverImagePath);
		al.setRecordingCompany(recordingCompany);
		al.setNumberOfTracks(numberOfTracks);
		al.setPmrcRating(pmrcRating);
		al.setNumberOfTracks(numberOfTracks);
		al.setPmrcRating(pmrcRating);
		al.setLength(length);
		
		// Add the Genre object to the ORM object grid
		em.persist(al);
		
		// Commit transaction
		em.getTransaction().commit();
		
		// Close connection to persistence manager
		em.close();
		emFactory.close();
		
		
	}
	
	public Album getAlbum(String albumID){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Ibt5_MusicJPA_Assignement8");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Album al = em.find(Album.class, albumID);
		
		
		
		em.close();
		emFactory.close();
		return al;
	}
	
	public JSONArray getAlbumList(String searchTerm, String searchType){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Ibt5_MusicJPA_Assignement8");
		EntityManager em = emFactory.createEntityManager();
		
		// Note that you are querying the object grid, not the database!
		String qry = "SELECT al.albumID FROM Album al ";
		
		
		
		if(!searchTerm.equals("")){
			if(searchType.equalsIgnoreCase("equals")){
				qry += "WHERE al.title = '" + searchTerm + "'";
			}
			else if(searchType.equalsIgnoreCase("begin")){
				qry += "WHERE al.title LIKE '" + searchTerm + "%'";
			}
			else if(searchType.equalsIgnoreCase("ends")){
				qry += "WHERE al.title LIKE '%" + searchTerm + "'";
			}
			else{
				qry += "WHERE al.title LIKE '%" + searchTerm + "%'";
			}
		}
		
		
		List<String> albumIDs = em.createQuery(qry).getResultList();
		JSONArray albumListJSON = new JSONArray();
		for(String albumID : albumIDs){
			Album al = em.find(Album.class, albumID);
			albumListJSON.put(al.toJSON());
		}
		em.close();
		emFactory.close();
		
		return albumListJSON;
	}
	public void updateArtist(String albumID,String title, String releaseDate,String coverImagePath,String recordingCompany,int numberOfTracks,String pmrcRating,int length){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Ibt5_MusicJPA_Assignement8");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Album al = em.find(Album.class, albumID);
		
		if(!title.equals("")){
			al.setTitle(title);
		}
		if(!releaseDate.equals("")){
			al.setReleaseDate(releaseDate);
		}
		if(!coverImagePath.equals("")){
			al.setCoverImagePath(coverImagePath);
		}
		if(!title.equals("")){
			al.setTitle(title);
		}
		if(!recordingCompany.equals("")){
			al.setRecordingCompany(recordingCompany);
		}
		if(numberOfTracks == 0){
			al.setNumberOfTracks(numberOfTracks);
		}
		if(!pmrcRating.equals("")){
			al.setPmrcRating(pmrcRating);
		}
		if (length == 0){
			al.setNumberOfTracks(length);
		}
		
		em.persist(al);
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
	}
	
	public void deletealbum(String albumID){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Ibt5_MusicJPA_Assignement8");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Album al = em.find(Album.class, albumID);
		
		em.remove(al);
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
	}
}
