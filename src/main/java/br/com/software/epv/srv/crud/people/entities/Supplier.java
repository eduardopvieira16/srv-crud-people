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
@Table(name = "suppliers")
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supplier_id")
	private Long supplierId;

	@ManyToOne
	@JoinColumn(name = "person_id", nullable = false)
	private Person person;

	@Column(name = "company_name", length = 150)
	private String companyName;

	@Column(name = "cnpj", length = 14)
	private String cnpj;

	public Supplier() {
	}

	public Supplier(Person person, String companyName, String cnpj) {
		this.person = person;
		this.companyName = companyName;
		this.cnpj = cnpj;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Supplier supplier = (Supplier) o;
		return Objects.equals(supplierId, supplier.supplierId) && Objects.equals(person, supplier.person)
				&& Objects.equals(companyName, supplier.companyName) && Objects.equals(cnpj, supplier.cnpj);
	}

	@Override
	public int hashCode() {
		return Objects.hash(supplierId, person, companyName, cnpj);
	}

	@Override
	public String toString() {
		return "Supplier{" + "supplierId=" + supplierId + ", person=" + person + ", companyName='" + companyName + '\''
				+ ", cnpj='" + cnpj + '\'' + '}';
	}
}