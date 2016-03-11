/**
 * 
 */
package pl.hubert.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

/**
 * @author Hubert
 *
 */
@Entity
@Table(name = "pracownicy")
@SecondaryTable(name = "adresy", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id_pracownika"))
public class MultiTableEntity {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "imie")
	private String firstName;
	@Column(name = "nazwisko")
	private String lastName;
	@Column(name = "pensja")
	private double salary;

	@Column(table = "adresy", name = "miejscowosc")
	private String locality;
	@Column(table = "adresy", name = "kod_pocztowy")
	private String zipCode;
	@Column(table = "adresy", name = "ulica")
	private String street;
	@Column(table = "adresy", name = "numer_domu")
	private int streetNumber;

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

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}
}
