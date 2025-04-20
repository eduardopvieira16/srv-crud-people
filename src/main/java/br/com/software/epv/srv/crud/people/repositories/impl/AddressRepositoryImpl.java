package br.com.software.epv.srv.crud.people.repositories.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.software.epv.srv.crud.people.entities.Address;
import br.com.software.epv.srv.crud.people.repositories.interfaces.AddressRepository;
import jakarta.persistence.EntityManager;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> listAllAddress() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address readByIdAddress(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address readByStreet(String street) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address readByZipCode(Long zipCode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}