/**
 * 
 */
package pl.hubert.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.hubert.jpa.domain.CatEntity;
import pl.hubert.jpa.domain.OwnerEntity;

/**
 * @author Hubert
 *
 */
public class Bidirectional {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
	
		OwnerEntity owner = new OwnerEntity();
		CatEntity cat = new CatEntity();
		
		owner.setFirstName("Jan");
		owner.setLastName("Kowalski");
		cat.setName("Mruczek");
		owner.setCat(cat);
		
		entityManager.getTransaction().begin();
		entityManager.persist(owner);
		entityManager.persist(cat);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
