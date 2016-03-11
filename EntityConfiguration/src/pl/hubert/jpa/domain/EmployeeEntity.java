/**
 * 
 */
package pl.hubert.jpa.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Hubert
 *
 */
@Entity
@Table(name = "employees")
public class EmployeeEntity {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name="imie", nullable = false, length = 10)
	private String firstName;

	@Column(name="nazwisko", columnDefinition = "VARCHAR(10) NOT NULL")
	private String lastName;

	@Column(name="pensja")
	private double salary;

	@Column(name="pensja2", precision = 10, scale = 2)
	private BigDecimal salary2;

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

	public BigDecimal getSalary2() {
		return salary2;
	}

	public void setSalary2(BigDecimal salary2) {
		this.salary2 = salary2;
	}

}
