package br.com.software.epv.srv.crud.people.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.software.epv.srv.crud.people.entities.Address;
import br.com.software.epv.srv.crud.people.repositories.impl.AddressRepositoryImpl;
import br.com.software.epv.srv.crud.people.services.interfaces.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepositoryImpl addressRepository;

	@Override
	public Address saveAddress(Address address) throws Exception {
		if (address == null) {
			addressRepository.createAddress(address);
			return address;
		} else {
			addressRepository.updateAddress(address);
			return address;
		}

	}

	@Override
	public Address deleteAddress(Address address) throws Exception {
		addressRepository.deleteAddress(address);
		return address;
	}

	@Override
	public List<Address> listAllAddress() throws Exception {
		return addressRepository.listAllAddress();
	}

	@Override
	public Address readByIdAddress(Long id) throws Exception {
		return addressRepository.readByIdAddress(id);
	}

	@Override
	public List<Address> listStreet(String street) throws Exception {
		return addressRepository.listStreet(street);
	}

	@Override
	public List<Address> listZipCode(String zipCode) throws Exception {
		return addressRepository.listZipCode(zipCode);
	}

	@Override
	public long count() throws Exception {
		return addressRepository.countAddress();
	}

}
