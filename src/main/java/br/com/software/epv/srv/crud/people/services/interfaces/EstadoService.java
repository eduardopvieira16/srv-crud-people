package br.com.software.epv.srv.crud.people.services.interfaces;

import java.util.List;

import br.com.software.epv.srv.crud.people.entities.Estado;

public interface EstadoService {

    Estado saveEstado(Estado estado) throws Exception;

    Estado deleteEstado(Estado estado) throws Exception;

    List<Estado> listAllEstados() throws Exception;

    Estado readByIdEstado(Long id) throws Exception;

    List<Estado> listEstadosByNome(String estado) throws Exception;

    List<Estado> listEstadosByUF(String uf) throws Exception;

    List<Estado> listEstadosByRegiao(String regiao) throws Exception;
    
    long countEstados() throws Exception;
}
