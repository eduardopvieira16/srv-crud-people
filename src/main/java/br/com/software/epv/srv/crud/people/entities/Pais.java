package br.com.software.epv.srv.crud.people.entities;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "paises")
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pais")
	private Long id;

	@Column(nullable = false, length = 100)
	private String pais;

	@Column(name = "codigo_telefone", length = 5)
	private String codigoTelefone;

	public Pais() {
	}

	public Pais(Long id, String pais, String codigoTelefone) {
		super();
		this.id = id;
		this.pais = pais;
		this.codigoTelefone = codigoTelefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCodigoTelefone() {
		return codigoTelefone;
	}

	public void setCodigoTelefone(String codigoTelefone) {
		this.codigoTelefone = codigoTelefone;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", pais=" + pais + ", codigoTelefone=" + codigoTelefone + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoTelefone, id, pais);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		return Objects.equals(codigoTelefone, other.codigoTelefone) && Objects.equals(id, other.id)
				&& Objects.equals(pais, other.pais);
	}

}
