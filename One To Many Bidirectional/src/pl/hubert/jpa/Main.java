/**
 * 
 */
package pl.hubert.jpa;

import java.util.ArrayList;
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
public class Main {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main(String[] args) {

		entityManagerFactory = Persistence
				.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();

		EmployeeEntity employee = new EmployeeEntity();
		
		employee.setFirstName("Blazej");
		employee.setLastName("åledü");
		employee.setSalary(333.3);

		PhoneEntity phone1 = new PhoneEntity();
		phone1.setType("mobile");
		phone1.setNumber("46456");
		phone1.setEmployee(employee);
		
		PhoneEntity phone2 = new PhoneEntity();
		phone2.setType("home");
		phone2.setNumber("2342342");
		phone2.setEmployee(employee);
		
		List<PhoneEntity> phones = new ArrayList<>();
		phones.add(phone1);
		phones.add(phone2);
		employee.setPhones(phones);

		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.persist(phone1);
		entityManager.persist(phone2);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
