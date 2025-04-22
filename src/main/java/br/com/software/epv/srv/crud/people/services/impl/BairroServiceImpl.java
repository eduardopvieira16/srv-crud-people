package br.com.software.epv.srv.crud.people.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.software.epv.srv.crud.people.entities.Bairro;
import br.com.software.epv.srv.crud.people.repositories.interfaces.BairroRepository;
import br.com.software.epv.srv.crud.people.services.interfaces.BairroService;

@Service
public class BairroServiceImpl implements BairroService {

	@Autowired
	private BairroRepository bairroRepository;

	@Override
	public Bairro saveBairro(Bairro bairro) throws Exception {
		if (bairro == null) {
			throw new IllegalArgumentException("Objeto Bairro não pode ser nulo");
		}

		if (bairro.getBairro() == null || bairro.getBairro().trim().isEmpty()) {
			throw new IllegalArgumentException("Nome do bairro é obrigatório");
		}

		if (bairro.getCep() == null || bairro.getCep().trim().isEmpty()) {
			throw new IllegalArgumentException("CEP do bairro é obrigatório");
		}

		if (bairro.getId() == null) {
			return bairroRepository.createBairro(bairro);
		} else {
			return bairroRepository.updateBairro(bairro);
		}
	}

	@Override
	public Bairro deleteBairro(Bairro bairro) throws Exception {
		if (bairro == null || bairro.getId() == null) {
			throw new IllegalArgumentException("ID do bairro é obrigatório para exclusão");
		}
		return bairroRepository.deleteBairro(bairro);
	}

	@Override
	public List<Bairro> listAllBairros() throws Exception {
		return bairroRepository.listAllBairro();
	}

	@Override
	public Bairro readByIdBairro(Long id) throws Exception {
		if (id == null) {
			throw new IllegalArgumentException("ID é obrigatório para busca por bairro");
		}
		return bairroRepository.readByIdBairro(id);
	}

	@Override
	public List<Bairro> listBairrosByNome(String nome) throws Exception {
		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome do bairro é obrigatório para busca");
		}
		return bairroRepository.listBairro(nome);
	}

	@Override
	public List<Bairro> listBairrosByCep(String cep) throws Exception {
		if (cep == null || cep.trim().isEmpty()) {
			throw new IllegalArgumentException("CEP é obrigatório para busca");
		}
		return bairroRepository.listCep(cep);
	}

	@Override
	public long countBairros() throws Exception {
		return bairroRepository.countBairro();
	}
}
