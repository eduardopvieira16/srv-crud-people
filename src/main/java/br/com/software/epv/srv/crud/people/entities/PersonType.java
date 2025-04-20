package br.com.software.epv.srv.crud.people.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "person_types")
public class PersonType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_type_id")
	private Integer personTypeId;

	@Column(name = "person_type", nullable = false, length = 50)
	private String personType;

	public PersonType() {
	}

	public PersonType(String personType) {
		this.personType = personType;
	}

	public Integer getPersonTypeId() {
		return personTypeId;
	}

	public void setPersonTypeId(Integer personTypeId) {
		this.personTypeId = personTypeId;
	}

	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PersonType that = (PersonType) o;
		return Objects.equals(personTypeId, that.personTypeId) && Objects.equals(personType, that.personType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(personTypeId, personType);
	}

	@Override
	public String toString() {
		return "PersonType{" + "personTypeId=" + personTypeId + ", personType='" + personType + '\'' + '}';
	}
}