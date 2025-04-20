package br.com.software.epv.srv.crud.people.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Long addressId;

	@ManyToOne
	@JoinColumn(name = "person_id", nullable = false)
	private Person person;

	@ManyToOne
	@JoinColumn(name = "city_id", nullable = false)
	private City city;

	@Column(name = "street", nullable = false, length = 150)
	private String street;

	@Column(name = "number_address", nullable = false, length = 20)
	private String numberAddress;

	@Column(name = "complement", length = 100)
	private String complement;

	@Column(name = "zip_code", nullable = false, length = 10)
	private String zipCode;

	public Address() {
	}

	public Address(Person person, City city, String street, String numberAddress, String complement, String zipCode) {
		this.person = person;
		this.city = city;
		this.street = street;
		this.numberAddress = numberAddress;
		this.complement = complement;
		this.zipCode = zipCode;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumberAddress() {
		return numberAddress;
	}

	public void setNumberAddress(String numberAddress) {
		this.numberAddress = numberAddress;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Address address = (Address) o;
		return Objects.equals(addressId, address.addressId) && Objects.equals(person, address.person)
				&& Objects.equals(city, address.city) && Objects.equals(street, address.street)
				&& Objects.equals(numberAddress, address.numberAddress)
				&& Objects.equals(complement, address.complement) && Objects.equals(zipCode, address.zipCode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(addressId, person, city, street, numberAddress, complement, zipCode);
	}

	@Override
	public String toString() {
		return "Address{" + "addressId=" + addressId + ", person=" + person + ", city=" + city + ", street='" + street
				+ '\'' + ", numberAddress='" + numberAddress + '\'' + ", complement='" + complement + '\''
				+ ", zipCode='" + zipCode + '\'' + '}';
	}
}