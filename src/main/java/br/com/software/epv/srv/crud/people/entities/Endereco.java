package br.com.software.epv.srv.crud.people.entities;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "enderecos")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_bairro")
	private Bairro bairro;

	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;

	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;

	@ManyToOne
	@JoinColumn(name = "id_pais")
	private Pais pais;

	@Column(nullable = false, length = 200)
	private String logradouro;

	public Endereco() {
	}

	public Endereco(Integer id, Bairro bairro, Cidade cidade, Estado estado, Pais pais, String logradouro) {
		super();
		this.id = id;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.logradouro = logradouro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", pais="
				+ pais + ", logradouro=" + logradouro + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cidade, estado, id, logradouro, pais);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cidade, other.cidade)
				&& Objects.equals(estado, other.estado) && Objects.equals(id, other.id)
				&& Objects.equals(logradouro, other.logradouro) && Objects.equals(pais, other.pais);
	}

}
