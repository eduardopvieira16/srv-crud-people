package br.com.software.epv.srv.crud.people.services.interfaces;

import java.util.List;

import br.com.software.epv.srv.crud.people.entities.Cidade;

public interface CidadeService {

    Cidade saveCidade(Cidade cidade) throws Exception;

    Cidade deleteCidade(Cidade cidade) throws Exception;

    List<Cidade> listAllCidades() throws Exception;

    Cidade readByIdCidade(Long id) throws Exception;

    List<Cidade> listCidadesByNome(String cidade) throws Exception;

    long countCidades() throws Exception;
}
