package pl.hubert.jpa.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//Domyœlne, oby³oby siê bez tego:
@DiscriminatorValue(value = "Studencik")
public class Student extends Person {

	private double averageGrade;

	public double getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}

}
