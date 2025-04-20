package br.com.software.epv.srv.crud.people.entities;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "people")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id")
	private Long personId;

	@Column(name = "person", nullable = false, length = 150)
	private String person;

	@Column(name = "cpf_cnpj", length = 14)
	private String cpfCnpj;

	@Column(name = "rg", length = 20)
	private String rg;

	@Column(name = "birth_date")
	private Date birthDate;

	@Column(name = "email", length = 100)
	private String email;

	@Column(name = "mobile", length = 20)
	private String mobile;

	@Column(name = "active")
	private Boolean active;

	public Person() {
	}

	public Person(String person, String cpfCnpj, String rg, Date birthDate, String email, String mobile,
			Boolean active) {
		this.person = person;
		this.cpfCnpj = cpfCnpj;
		this.rg = rg;
		this.birthDate = birthDate;
		this.email = email;
		this.mobile = mobile;
		this.active = active;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Person person1 = (Person) o;
		return Objects.equals(personId, person1.personId) && Objects.equals(person, person1.person)
				&& Objects.equals(cpfCnpj, person1.cpfCnpj) && Objects.equals(rg, person1.rg)
				&& Objects.equals(birthDate, person1.birthDate) && Objects.equals(email, person1.email)
				&& Objects.equals(mobile, person1.mobile) && Objects.equals(active, person1.active);
	}

	@Override
	public int hashCode() {
		return Objects.hash(personId, person, cpfCnpj, rg, birthDate, email, mobile, active);
	}

	@Override
	public String toString() {
		return "Person{" + "personId=" + personId + ", person='" + person + '\'' + ", cpfCnpj='" + cpfCnpj + '\''
				+ ", rg='" + rg + '\'' + ", birthDate=" + birthDate + ", email='" + email + '\'' + ", mobile='" + mobile
				+ '\'' + ", active=" + active + '}';
	}
}