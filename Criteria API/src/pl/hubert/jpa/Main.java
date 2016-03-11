/**
 * 
 */
package pl.hubert.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

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
		
		// select e from EmployeeEntity e where e.salary > 3000 and e.salary < 30000
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<EmployeeEntity> criteriaQuery = builder.createQuery(EmployeeEntity.class);
		Root<EmployeeEntity> employee = criteriaQuery.from(EmployeeEntity.class);
		
		Path<Double> salary = employee.get("salary");
		criteriaQuery.select(employee).where(builder.and(builder.greaterThan(salary, 3000.0),builder.lessThan(salary, 30000.0)));
		
		TypedQuery<EmployeeEntity> query = entityManager.createQuery(criteriaQuery);
		List<EmployeeEntity> employees = query.getResultList();
		
		for(EmployeeEntity emp : employees) {
			System.out.println(emp.getFirstName());
			System.out.println(emp.getLastName());
			System.out.println(emp.getSalary());
			System.out.println();
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
