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
@Table(name = "cities")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private Long cityId;

	@ManyToOne
	@JoinColumn(name = "state_id", nullable = false)
	private State state;

	@Column(name = "city", nullable = false, length = 100)
	private String city;

	public City() {
	}

	public City(State state, String city) {
		this.state = state;
		this.city = city;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		City city1 = (City) o;
		return Objects.equals(cityId, city1.cityId) && Objects.equals(state, city1.state)
				&& Objects.equals(city, city1.city);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cityId, state, city);
	}

	@Override
	public String toString() {
		return "City{" + "cityId=" + cityId + ", state=" + state + ", city='" + city + '\'' + '}';
	}
}