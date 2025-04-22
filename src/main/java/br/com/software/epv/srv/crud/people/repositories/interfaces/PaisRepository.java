package br.com.software.epv.srv.crud.people.repositories.interfaces;

import java.util.List;

import br.com.software.epv.srv.crud.people.entities.Pais;


public interface PaisRepository {
	Pais createPais(Pais bairro) throws Exception;

	Pais updatePais(Pais bairro) throws Exception;

	Pais deletePais(Pais bairro) throws Exception;

	List<Pais> listAllPais() throws Exception;

	Pais readByIdPais(Long id) throws Exception;

	List<Pais> listPais(String bairro) throws Exception;

	List<Pais> listCep(String cep) throws Exception;

	long countPais() throws Exception;
}