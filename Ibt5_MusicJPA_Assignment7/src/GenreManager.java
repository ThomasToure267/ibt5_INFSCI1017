import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenreManager {
	
	public void createGenre(int genreID,String genreName, String descr) {
		EntityManagerFactory emFactory = 
				Persistence.createEntityManagerFactory("Ibt5_MusicJPA_Assignment7Genre");
		
		EntityManager em = emFactory.createEntityManager();
		
		
		em.getTransaction().begin();
		
		Genre g = new Genre();
		g.setGenreID(genreID);
		g.setGenreName(genreName);
		g.setDescription(descr);
		
		
		//Artist a = new Artist();
		//a.setArtistID(UUID.randomUUID().toString());
		
		em.persist(g);
		
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
		
	}
	
	
	public Genre getGenre(String genreID) {
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Ibt5_MusicJPA_Assignment7");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Genre g = em.find(Genre.class, genreID);

		em.close();
		emFactory.close();
		return g;    
	}
	
	// public void updateGenre()

}
