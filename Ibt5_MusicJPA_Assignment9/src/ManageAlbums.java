import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ManageAlbums {
	public void createAlbum (String title, String releaseDate,String coverImagePath,String recordingCompany,int numberOfTracks,String pmrcRating,int length){
		EntityManagerFactory emFactory = 
				Persistence.createEntityManagerFactory("Ibt5_MusicJPA_Assignment7Genre");
		
		EntityManager em = emFactory.createEntityManager();
		
		em.getTransaction().begin();
		
		
		
		
		 Album a = new Album();
		 
		 a.setAlbumID(UUID.randomUUID().toString());
		 
		
		a.setTitle(title);
		a.setReleaseDate(releaseDate);
		a.setCoverImagePath(coverImagePath);
		a.setRecordingCompany(recordingCompany);
		a.setNumberOfTracks(numberOfTracks);
		a.setPmrcRating(pmrcRating);
		a.setNumberOfTracks(numberOfTracks);
		a.setPmrcRating(pmrcRating);
		a.setLength(length);
		
		
		// Add the Artist object to the ORM object grid
		em.persist(a);
		
		// Commit transaction
		em.getTransaction().commit();
		
		// Close connection to persistence manager
		em.close();
		emFactory.close();
		
	}
	
	
	public void updateAlbum(String albumID, String title, String releaseDate,String coverImagePath,String recordingCompany,int numberOfTracks,String pmrcRating,int length){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Ibt5_MusicJPA_Assignment7Genre");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Album a = em.find(Album.class, albumID);
		
		if(!title.equals("")){
			a.setTitle(title);
		}
		
		if(!releaseDate.equals("")){
			a.setReleaseDate(releaseDate);
		}
		if(!coverImagePath.equals("")) {
			a.setCoverImagePath(coverImagePath);
			
		}
		if(!recordingCompany.equals("")) {
			a.setRecordingCompany(recordingCompany);
		}
		if(!(numberOfTracks==0)) {
			a.setNumberOfTracks(numberOfTracks);
		}
		if(!pmrcRating.equals("")) {
			a.getPmrcRating();
		}
		if(!(length==0)) {
			a.setLength(length);
		}
		
		
		em.persist(a);
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
	}
	
	public void deleteAlbum(String albumID){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Ibt5_MusicJPA_Assignment7Genre");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Album a = em.find(Album.class, albumID);
		
		em.remove(a);
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
	}
	
	public Album findAlbum(String albumID) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Ibt5_MusicJPA_Assignment7Genre");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Album a = em.find(Album.class, albumID);
		
		System.out.println(a.getAlbumID());
		System.out.println(a.getTitle());
		System.out.println(a.getReleaseDate());
		System.out.println(a.getCoverImagePath());
		System.out.println(a.getRecordingCompany());
		System.out.println(a.getNumberOfTracks());
		System.out.println(a.getPmrcRating());
		System.out.println(a.getLength());
		// Add the Artist object to the ORM object grid
		em.persist(a);
		
		// Commit transaction
		em.getTransaction().commit();
		
		// Close connection to persistence manager
		em.close();
		emFactory.close();
		
		return a;

	}

}
