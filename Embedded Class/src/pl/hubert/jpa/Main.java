/**
 * 
 */
package pl.hubert.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.hubert.jpa.domain.Address;
import pl.hubert.jpa.domain.EmployeeEntity;

/**
 * @author Hubert
 *
 */
public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EmployeeEntity employee = new EmployeeEntity();
		Address address = new Address();
		employee.setFirstName("Hubert");
		employee.setLastName("Popiolkiewicz");
		employee.setSalary(333.3);
		employee.setAddress(address);
		address.setLocality("Poznan");
		address.setZipCode("12-234");
		address.setStreet("Chrobrego");
		address.setStreetNumber(15);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
