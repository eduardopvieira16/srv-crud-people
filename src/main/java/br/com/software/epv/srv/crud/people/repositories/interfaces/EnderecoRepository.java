package br.com.software.epv.srv.crud.people.repositories.interfaces;

import java.util.List;

import br.com.software.epv.srv.crud.people.entities.Bairro;


public interface EnderecoRepository {
	Bairro createBairro(Bairro bairro) throws Exception;

	Bairro updateBairro(Bairro bairro) throws Exception;

	Bairro deleteBairro(Bairro bairro) throws Exception;

	List<Bairro> listAllBairro() throws Exception;

	Bairro readByIdBairro(Long id) throws Exception;

	List<Bairro> listBairro(String bairro) throws Exception;

	List<Bairro> listCep(String cep) throws Exception;

	long countBairro() throws Exception;
}