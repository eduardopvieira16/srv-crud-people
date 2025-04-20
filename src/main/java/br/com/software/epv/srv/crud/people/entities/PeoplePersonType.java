package br.com.software.epv.srv.crud.people.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "people_person_types")
public class PeoplePersonType {
	@Id
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;

	@Id
	@ManyToOne
	@JoinColumn(name = "person_type_id")
	private PersonType personType;

	public PeoplePersonType() {
	}

	public PeoplePersonType(Person person, PersonType personType) {
		this.person = person;
		this.personType = personType;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public PersonType getPersonType() {
		return personType;
	}

	public void setPersonType(PersonType personType) {
		this.personType = personType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PeoplePersonType that = (PeoplePersonType) o;
		return Objects.equals(person, that.person) && Objects.equals(personType, that.personType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(person, personType);
	}

	@Override
	public String toString() {
		return "PeoplePersonType{" + "person=" + person + ", personType=" + personType + '}';
	}
}