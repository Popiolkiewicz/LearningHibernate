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
@Entity(name = "Cat")
public class CatEntity {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@OneToOne(mappedBy = "cat")
	private OwnerEntity owner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OwnerEntity getOwner() {
		return owner;
	}

	public void setOwner(OwnerEntity owner) {
		this.owner = owner;
	}
}
