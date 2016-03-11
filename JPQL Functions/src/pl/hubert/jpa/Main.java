/**
 * 
 */
package pl.hubert.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
		
		Query query = entityManager.createQuery("select avg(e.salary), max(e.salary), min(e.salary),"
				+ " sum(e.salary), count(e) from EmployeeEntity e");
		Object[] result = (Object[]) query.getSingleResult();
		System.out.println("Srednia: " + result[0]);
		System.out.println("Najwyzsza: " + result[1]);
		System.out.println("Najnizsza: " + result[2]);
		System.out.println("Suma: " + result[3]);
		System.out.println("Pracowników: " + result[4]);
		

		Query query1 = entityManager.createQuery("select substring(e.firstName, 1, 3), trim(e.lastName), lower(e.firstName),"
				+ " upper(e.firstName), length(e.firstName) from EmployeeEntity e where e.firstName = :thisName");
		query1.setParameter("thisName", "Hubert");
		Object[] result1 = (Object[]) query1.getSingleResult();
		System.out.println("Pierwsze trzy litery imienia: " + result1[0]);
		System.out.println("Nazwisko : |" + result1[1] + "|");
		System.out.println("Imiê ma³ymi literkami: " + result1[2]);
		System.out.println("Imiê du¿ymi literkami: " + result1[3]);
		System.out.println("D³ugosæ imienia: " + result1[4]);
		
		entityManager.close();
		entityManagerFactory.close();
	}

	private static void addEmployees() {
		addEmployee("Hubert", "     Pop     ", 1234);
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
