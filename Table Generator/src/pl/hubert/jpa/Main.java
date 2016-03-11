/**
 * 
 */
package pl.hubert.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.hubert.jpa.domain.Employee;

/**
 * @author Hubert
 *
 */
public class Main {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main(String[] args) {

		entityManagerFactory = Persistence
				.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();

		Employee employee1 = new Employee("Jan", "Nowak", 123.0);
		Employee employee2 = new Employee("Maria", "Kowalska", 123.0);
		Employee employee3 = new Employee("Iwona", "Uciñska", 123.0);

		entityManager.getTransaction().begin();
		entityManager.persist(employee1);
		entityManager.persist(employee2);
		entityManager.persist(employee3);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}
}
