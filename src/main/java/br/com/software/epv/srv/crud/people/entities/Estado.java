package br.com.software.epv.srv.crud.people.entities;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "estados")
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado")
	private Long id;

	@Column(nullable = false, length = 100)
	private String estado;

	@Column(nullable = false, length = 2)
	private String uf;

	@Column(name = "codigo_ibge", length = 2)
	private String codigoIbge;

	@Column(length = 50)
	private String regiao;

	public Estado() {
	}

	public Estado(Long id, String estado, String uf, String codigoIbge, String regiao) {
		super();
		this.id = id;
		this.estado = estado;
		this.uf = uf;
		this.codigoIbge = codigoIbge;
		this.regiao = regiao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCodigoIbge() {
		return codigoIbge;
	}

	public void setCodigoIbge(String codigoIbge) {
		this.codigoIbge = codigoIbge;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", estado=" + estado + ", uf=" + uf + ", codigoIbge=" + codigoIbge + ", regiao="
				+ regiao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoIbge, estado, id, regiao, uf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		return Objects.equals(codigoIbge, other.codigoIbge) && Objects.equals(estado, other.estado)
				&& Objects.equals(id, other.id) && Objects.equals(regiao, other.regiao) && Objects.equals(uf, other.uf);
	}

}
