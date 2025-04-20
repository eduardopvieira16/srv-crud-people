package br.com.software.epv.srv.crud.people.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id")
	private Long countryId;

	@Column(name = "country", nullable = false, length = 100)
	private String country;

	@Column(name = "postal_code", nullable = false, length = 10)
	private String postalCode;

	public Country() {
	}

	public Country(String country, String postalCode) {
		this.country = country;
		this.postalCode = postalCode;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Country country1 = (Country) o;
		return Objects.equals(countryId, country1.countryId) && Objects.equals(country, country1.country)
				&& Objects.equals(postalCode, country1.postalCode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(countryId, country, postalCode);
	}

	@Override
	public String toString() {
		return "Country{" + "countryId=" + countryId + ", country='" + country + '\'' + ", postalCode='" + postalCode
				+ '\'' + '}';
	}
}