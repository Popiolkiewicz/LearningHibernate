/**
 * 
 */
package pl.hubert.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Hubert
 *
 */
@Entity
public class EmployeeEntity {

	@Id
	private Long id;
	private String firstName;
	private String lastName;
	private double salary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
