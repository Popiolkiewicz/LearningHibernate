/**
 * 
 */
package pl.hubert.jpa;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import pl.hubert.jpa.domain.EmployeeEntity;

/**
 * @author Hubert
 *
 */
public class Main {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	public static void main(String[] args) {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();

		addEmployees();
		
		TypedQuery<EmployeeEntity> query = entityManager.createQuery("SELECT e FROM EmployeeEntity e WHERE e.lastName = 'Klub'", EmployeeEntity.class);
		EmployeeEntity employee = query.getSingleResult();
		System.out.println("First name: " + employee.getFirstName());
		System.out.println("Last name: " + employee.getLastName());
		System.out.println("Salary: " + employee.getSalary());
		
		TypedQuery<EmployeeEntity> query1 = entityManager.createQuery("SELECT e FROM EmployeeEntity e WHERE e.salary > 1000", EmployeeEntity.class);
		List<EmployeeEntity> employees = query1.getResultList();
		for(EmployeeEntity empl : employees) {
			System.out.println("First name: " + empl.getFirstName());
			System.out.println("Last name: " + empl.getLastName());
			System.out.println("Salary: " + empl.getSalary());
		}
		
		Query query2 = entityManager.createQuery("SELECT CONCAT(e.firstName, ' ' , e.lastName), e.salary * 0.2 FROM EmployeeEntity e");
		Iterator<?> iterator = query2.getResultList().iterator();
		while (iterator.hasNext()) {
			Object[] item = (Object[]) iterator.next();
			String name = (String) item[0];
			double tax = (double) item[1];
			System.out.println(name + " has to pay " + tax);
		}
		entityManager.close();
		entityManagerFactory.close();
	}

	private static void addEmployees() {
		addEmployee("Hubert", "Pop", 1234);
		addEmployee("B³a¿ej", "asdf", 345);
		addEmployee("Robert", "Bób", 23423);
		addEmployee("Jakub", "Klub", 34535);
		addEmployee("Klaudia", "Kowalski", 1234);
		addEmployee("Justyna", "Nowak", 564);
		addEmployee("Bo¿ydar", "G³¹b", 645);
	}

	private static void addEmployee(String firstName, String lastName, double salary) {
		EmployeeEntity employee = new EmployeeEntity();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setSalary(salary);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
	}
}
