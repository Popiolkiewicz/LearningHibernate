/**
 * 
 */
package pl.hubert.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.hubert.jpa.domain.MultiTableEntity;

/**
 * @author Hubert
 *
 */
public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		MultiTableEntity employee = new MultiTableEntity();
		employee.setFirstName("Hubert");
		employee.setLastName("Popiolkiewicz");
		employee.setSalary(333.3);
		employee.setLocality("Poznan");
		employee.setZipCode("12-234");
		employee.setStreet("Chrobrego");
		employee.setStreetNumber(15);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
