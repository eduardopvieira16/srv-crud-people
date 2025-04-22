package br.com.software.epv.srv.crud.people.services.interfaces;

import java.util.List;

import br.com.software.epv.srv.crud.people.entities.Pais;

public interface PaisService {

    Pais savePais(Pais pais) throws Exception;

    Pais deletePais(Pais pais) throws Exception;

    List<Pais> listAllPaises() throws Exception;

    Pais readByIdPais(Long id) throws Exception;

    List<Pais> listPaissByNomes(String pais) throws Exception;

    long countPaises() throws Exception;
}
