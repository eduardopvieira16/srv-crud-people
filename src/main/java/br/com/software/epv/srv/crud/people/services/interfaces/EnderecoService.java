package br.com.software.epv.srv.crud.people.services.interfaces;

import java.util.List;

import br.com.software.epv.srv.crud.people.entities.Bairro;

public interface EnderecoService {

    Bairro saveBairro(Bairro bairro) throws Exception;

    Bairro deleteBairro(Bairro bairro) throws Exception;

    List<Bairro> listAllBairros() throws Exception;

    Bairro readByIdBairro(Long id) throws Exception;

    List<Bairro> listBairrosByNome(String bairro) throws Exception;

    List<Bairro> listBairrosByCep(String cep) throws Exception;

    long countBairros() throws Exception;
}
