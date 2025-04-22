package br.com.software.epv.srv.crud.people.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.software.epv.srv.crud.people.entities.Bairro;
import br.com.software.epv.srv.crud.people.services.impl.BairroServiceImpl;

@RestController
@RequestMapping("/v1/bairro")
public class BairroController {

	@Autowired
	private BairroServiceImpl bairroService;

	@GetMapping("/all")
	public List<Bairro> listAll() throws Exception {
		try {
			return bairroService.listAllBairros();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
