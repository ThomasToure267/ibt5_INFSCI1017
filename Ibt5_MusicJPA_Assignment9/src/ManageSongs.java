import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class ManageSongs {
	
	public void  createSong (String title, int length,String filePath,String releaseDate,String recordDate){
		EntityManagerFactory emFactory = 
				Persistence.createEntityManagerFactory("Ibt5_MusicJPA_Assignment7Genre");
		
		EntityManager em = emFactory.createEntityManager();
		
		em.getTransaction().begin();
		
		
		
		
		 Song s = new Song();
		 
		 s.setSongID(UUID.randomUUID().toString());
		 
		
		s.setTitle(title);
		s.setLength(length);
		s.setFilePath(filePath);
		s.setReleaseDate(releaseDate);
		s.setRecordDate(recordDate);
		
		
		// Add the Artist object to the ORM object grid
		em.persist(s);
		
		// Commit transaction
		em.getTransaction().commit();
		
		// Close connection to persistence manager
		em.close();
		emFactory.close();
		
	}
	
	
	public void updateSong(String songID,String title, int length,String filePath,String releaseDate,String recordDate){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Ibt5_MusicJPA_Assignment7Genre");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Song s = em.find(Song.class,songID);
		
		if(!title.equals("")){
			s.setTitle(title);
		}
		
		if(!(length==0)){
			s.setLength(length);
		}
		if(!filePath.equals("")) {
			s.setFilePath(filePath);
			
		}
		if(!releaseDate.equals("")) {
			s.setReleaseDate(releaseDate);
		}
		if(!recordDate.equals("")) {
			s.setRecordDate(recordDate);
		}
		
		em.persist(s);
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
	}
	
	public void deleteSong(String songID){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Ibt5_MusicJPA_Assignment7Genre");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Song s = em.find(Song.class,songID);
		
		em.remove(s);
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
	}
	
	public Song findSong(String songID) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Ibt5_MusicJPA_Assignment7Genre");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Song s1 = em.find(Song.class,songID);
		
		System.out.println(s1.getTitle());
		System.out.println(s1.getLength());
		System.out.println(s1.getFilePath());
		System.out.println(s1.getRecordDate());
		System.out.println(s1.getReleaseDate());
		
		
		// Add the Artist object to the ORM object grid
		em.persist(s1);
		
		// Commit transaction
		em.getTransaction().commit();
		
		// Close connection to persistence manager
		em.close();
		emFactory.close();
		
		return s1;

	}

}
