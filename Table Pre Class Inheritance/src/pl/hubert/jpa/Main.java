/**
 * 
 */
package pl.hubert.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.hubert.jpa.domain.Professor;
import pl.hubert.jpa.domain.Student;

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

		Professor professor = new Professor();
		professor.setFirstName("Jan");
		professor.setLastName("Kowalski");
		professor.setSalary(345.0);
		
		Student student = new Student();
		student.setFirstName("Hubert");
		student.setLastName("Popiolkiewicz");
		student.setAverageGrade(4.75);
		
		entityManager.getTransaction().begin();
		entityManager.persist(professor);
		entityManager.persist(student);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}
}
