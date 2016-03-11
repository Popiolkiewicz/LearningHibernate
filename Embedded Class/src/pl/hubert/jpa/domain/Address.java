/**
 * 
 */
package pl.hubert.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Hubert
 *
 */
@Embeddable
public class Address {

	@Column(name = "miejscowosc")
	private String locality;
	@Column(name = "kod_pocztowy")
	private String zipCode;
	@Column(name = "ulica")
	private String street;
	@Column(name = "numer_domu")
	private int streetNumber;

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
