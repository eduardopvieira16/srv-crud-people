package br.com.software.epv.srv.crud.people.entities;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "bairros")
public class Bairro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_bairro")
	private Long id;

	@Column(nullable = false, length = 100)
	private String bairro;

	@Column(length = 10)
	private String cep;

	public Bairro() {
	}

	public Bairro(Long id, String bairro, String cep) {
		super();
		this.id = id;
		this.bairro = bairro;
		this.cep = cep;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Bairro [id=" + id + ", bairro=" + bairro + ", cep=" + cep + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bairro other = (Bairro) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep) && Objects.equals(id, other.id);
	}

}