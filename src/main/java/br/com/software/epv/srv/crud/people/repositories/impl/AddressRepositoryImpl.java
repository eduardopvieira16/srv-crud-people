package br.com.software.epv.srv.crud.people.repositories.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.software.epv.srv.crud.people.entities.Address;
import br.com.software.epv.srv.crud.people.repositories.interfaces.AddressRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;

@Repository
public class AddressRepositoryImpl implements AddressRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Address createAddress(Address address) throws Exception {
		if (address == null) {
			throw new IllegalArgumentException("Endereço não pode ser nulo");
		}

		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();

			if (address.getAddressId() != null) {
				throw new IllegalArgumentException("Para criar um novo endereço, o ID deve ser nulo");
			}

			em.persist(address);
			transaction.commit();
			return address;
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new RuntimeException("Erro ao criar o endereço", e);
		} finally {
			if (transaction.isActive() && !transaction.getRollbackOnly()) {
				transaction.rollback();
			}
		}
	}

	@Override
	public Address updateAddress(Address address) throws Exception {
		if (address == null) {
			throw new IllegalArgumentException("Endereço não pode ser nulo");
		}

		if (address.getAddressId() == null) {
			throw new IllegalArgumentException("ID do endereço não pode ser nulo para atualização");
		}

		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();

			Address existing = em.find(Address.class, address.getAddressId());
			if (existing == null) {
				throw new IllegalArgumentException("Endereço com ID " + address.getAddressId() + " não encontrado");
			}

			Address updatedAddress = em.merge(address);
			transaction.commit();
			return updatedAddress;
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new RuntimeException("Erro ao atualizar o endereço", e);
		} finally {
			if (transaction.isActive() && !transaction.getRollbackOnly()) {
				transaction.rollback();
			}
		}
	}

	@Override
	public Address deleteAddress(Address address) throws Exception {
		if (address == null) {
			throw new IllegalArgumentException("Endereço não pode ser nulo");
		}

		if (address.getAddressId() == null) {
			throw new IllegalArgumentException("ID do endereço não pode ser nulo para exclusão");
		}

		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();

			Address addressToDelete = em.find(Address.class, address.getAddressId());
			if (addressToDelete == null) {
				throw new IllegalArgumentException("Endereço com ID " + address.getAddressId() + " não encontrado");
			}

			em.remove(addressToDelete);
			transaction.commit();

			return addressToDelete;
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new RuntimeException("Erro ao excluir o endereço", e);
		} finally {
			if (transaction.isActive() && !transaction.getRollbackOnly()) {
				transaction.rollback();
			}
		}
	}

	@Override
	public List<Address> listAllAddress() throws Exception {
		try {
			String jpql = "SELECT address FROM Address address ORDER BY address.street asc";
			return em.createQuery(jpql, Address.class).getResultList();
		} catch (Exception e) {
			throw new Exception("Erro ao listar todos os endereços", e);
		}
	}

	@Override
	public Address readByIdAddress(Long id) throws Exception {

		try {
			Address address = em.find(Address.class, id);
			if (address == null) {
				throw new EntityNotFoundException("Endereço com ID " + id + " não encontrado");
			}
			return address;
		} catch (Exception e) {
			throw new Exception("Erro ao buscar endereço por ID", e);
		}
	}

	@Override
	public List<Address> listStreet(String street) throws Exception {
		if (street == null || street.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome da rua não encontrado");
		}

		try {
			String jpql = "SELECT address FROM Address address WHERE LOWER(address.street) LIKE LOWER(:street) ORDER BY address.street asc";
			return em.createQuery(jpql, Address.class).setParameter("street", "%" + street + "%").getResultList();
		} catch (Exception e) {
			throw new Exception("Erro ao buscar endereços por rua", e);
		}
	}

	@Override
	public List<Address> listZipCode(String zipCode) throws Exception {

		try {
			String jpql = "SELECT address FROM Address address WHERE address.zipCode = :zipCode ORDER BY address.street asc";
			return em.createQuery(jpql, Address.class).setParameter("zipCode", zipCode).getResultList();
		} catch (Exception e) {
			throw new Exception("Erro ao buscar o código do País", e);
		}
	}

	@Override
	public long countAddress() throws Exception {
		try {
			String jpql = "SELECT COUNT(address) FROM Address address";
			return em.createQuery(jpql, Long.class).getSingleResult();
		} catch (Exception e) {
			throw new Exception("Erro ao contar endereços", e);
		}
	}
}