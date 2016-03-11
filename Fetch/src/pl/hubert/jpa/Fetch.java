/**
 * 
 */
package pl.hubert.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.hubert.jpa.domain.EmployeeEntity;
import pl.hubert.jpa.domain.PhoneEntity;

/**
 * @author Hubert
 *
 */
public class Fetch {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main(String[] args) {

		entityManagerFactory = Persistence
				.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();

		EmployeeEntity employee = entityManager.find(EmployeeEntity.class, 1L);
		List<PhoneEntity> phones = employee.getPhones();
		System.out.println(phones);
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
