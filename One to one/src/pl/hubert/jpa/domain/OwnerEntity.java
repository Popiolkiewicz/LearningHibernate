/**
 * 
 */
package pl.hubert.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Hubert
 *
 */
@Entity(name = "Owner")
public class OwnerEntity {

	@Id
	@GeneratedValue
	private Long id;

	private String firstName;
	private String lastName;

	@OneToOne
	private CatEntity cat;

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

	public CatEntity getCat() {
		return cat;
	}

	public void setCat(CatEntity cat) {
		this.cat = cat;
	}

}
