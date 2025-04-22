package br.com.software.epv.srv.crud.people.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.software.epv.srv.crud.people.entities.Address;
import br.com.software.epv.srv.crud.people.services.impl.AddressServiceImpl;

@RestController
@RequestMapping("/v1/address")
public class AddressController {

	@Autowired
	private AddressServiceImpl addressService;

	@GetMapping("/all")
	public List<Address> listAll() throws Exception {
		try {
			return addressService.listAllAddress();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
