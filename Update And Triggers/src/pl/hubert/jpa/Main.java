/**
 * 
 */
package pl.hubert.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
		employee.setFirstName("Klaudia");
		employee.setLastName("Wyszatycka");
		employee.setSalary(3000);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		
		System.out.println("First name: " + employee.getFirstName());
		System.out.println("Last name: " + employee.getLastName());
		System.out.println("Salary: " + employee.getSalary());
		System.out.println("Tax: " + employee.getTax());

		entityManager.refresh(employee);
		
		System.out.println("First name: " + employee.getFirstName());
		System.out.println("Last name: " + employee.getLastName());
		System.out.println("Salary: " + employee.getSalary());
		System.out.println("Tax: " + employee.getTax());
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
