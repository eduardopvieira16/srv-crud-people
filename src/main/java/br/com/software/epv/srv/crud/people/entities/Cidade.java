package br.com.software.epv.srv.crud.people.entities;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "cidades")
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cidade")
	private Long id;

	@Column(nullable = false, length = 100)
	private String cidade;

	@Column(name = "codigo_ibge", length = 7)
	private String codigoIbge;

	@Column(length = 2)
	private String ddd;

	public Cidade() {

	}

	public Cidade(Long id, String cidade, String codigoIbge, String ddd) {
		super();
		this.id = id;
		this.cidade = cidade;
		this.codigoIbge = codigoIbge;
		this.ddd = ddd;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCodigoIbge() {
		return codigoIbge;
	}

	public void setCodigoIbge(String codigoIbge) {
		this.codigoIbge = codigoIbge;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	@Override
	public String toString() {
		return "Cidade [id=" + id + ", cidade=" + cidade + ", codigoIbge=" + codigoIbge + ", ddd=" + ddd + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cidade, codigoIbge, ddd, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		return Objects.equals(cidade, other.cidade) && Objects.equals(codigoIbge, other.codigoIbge)
				&& Objects.equals(ddd, other.ddd) && Objects.equals(id, other.id);
	}

}
