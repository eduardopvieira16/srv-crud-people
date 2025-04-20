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
@Table(name = "states")
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "state_id")
	private Long stateId;

	@ManyToOne
	@JoinColumn(name = "country_id", nullable = false)
	private Country country;

	@Column(name = "state", nullable = false, length = 100)
	private String state;

	@Column(name = "abbreviation", nullable = false, length = 2)
	private String abbreviation;

	public State() {
	}

	public State(Country country, String state, String abbreviation) {
		this.country = country;
		this.state = state;
		this.abbreviation = abbreviation;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		State state1 = (State) o;
		return Objects.equals(stateId, state1.stateId) && Objects.equals(country, state1.country)
				&& Objects.equals(state, state1.state) && Objects.equals(abbreviation, state1.abbreviation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(stateId, country, state, abbreviation);
	}

	@Override
	public String toString() {
		return "State{" + "stateId=" + stateId + ", country=" + country + ", state='" + state + '\''
				+ ", abbreviation='" + abbreviation + '\'' + '}';
	}
}