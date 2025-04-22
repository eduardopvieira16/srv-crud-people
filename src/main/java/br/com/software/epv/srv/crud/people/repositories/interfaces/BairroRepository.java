package br.com.software.epv.srv.crud.people.repositories.interfaces;

import java.util.List;

import br.com.software.epv.srv.crud.people.entities.Address;

public interface AddressRepository {
	Address createAddress(Address address) throws Exception;

	Address updateAddress(Address address) throws Exception;

	Address deleteAddress(Address address) throws Exception;

	List<Address> listAllAddress() throws Exception;

	Address readByIdAddress(Long id) throws Exception;

	List<Address> listStreet(String street) throws Exception;

	List<Address> listZipCode(String zipCode) throws Exception;

	long countAddress() throws Exception;
}