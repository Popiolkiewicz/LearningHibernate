/**
 * 
 */
package pl.hubert.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Hubert
 *
 */
@Entity(name = "phone")
@Table(name = "one_to_many_uni_phone")
public class PhoneEntity {

	@Id
	@GeneratedValue
	private Long id;
	private String type;
	private String number;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}


}
