package br.com.software.epv.srv.crud.people.repositories.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.software.epv.srv.crud.people.entities.Bairro;
import br.com.software.epv.srv.crud.people.repositories.interfaces.BairroRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;

@Repository
public class BairroRepositoryImpl implements BairroRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Bairro createBairro(Bairro bairro) throws Exception {
		if (bairro == null) {
			throw new IllegalArgumentException("Bairro não pode ser nulo");
		}
		if (bairro.getId() != null) {
			throw new IllegalArgumentException("O ID do bairro deve ser nulo ao criar um novo registro");
		}

		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(bairro);
			transaction.commit();
			return bairro;
		} catch (Exception e) {
			if (transaction.isActive())
				transaction.rollback();
			throw new RuntimeException("Erro ao criar o bairro", e);
		} finally {
			if (transaction.isActive() && !transaction.getRollbackOnly()) {
				transaction.rollback();
			}
		}
	}

	@Override
	public Bairro updateBairro(Bairro bairro) throws Exception {
		if (bairro == null) {
			throw new IllegalArgumentException("Bairro não pode ser nulo");
		}
		if (bairro.getId() == null) {
			throw new IllegalArgumentException("O ID do bairro é obrigatório para atualização");
		}

		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			Bairro existente = em.find(Bairro.class, bairro.getId());
			if (existente == null) {
				throw new IllegalArgumentException("Bairro com ID " + bairro.getId() + " não encontrado");
			}
			Bairro atualizado = em.merge(bairro);
			transaction.commit();
			return atualizado;
		} catch (Exception e) {
			if (transaction.isActive())
				transaction.rollback();
			throw new RuntimeException("Erro ao atualizar o bairro", e);
		} finally {
			if (transaction.isActive() && !transaction.getRollbackOnly()) {
				transaction.rollback();
			}
		}
	}

	@Override
	public Bairro deleteBairro(Bairro bairro) throws Exception {
		if (bairro == null) {
			throw new IllegalArgumentException("Bairro não pode ser nulo");
		}
		if (bairro.getId() == null) {
			throw new IllegalArgumentException("O ID do bairro é obrigatório para exclusão");
		}

		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			Bairro existente = em.find(Bairro.class, bairro.getId());
			if (existente == null) {
				throw new IllegalArgumentException("Bairro com ID " + bairro.getId() + " não encontrado");
			}
			em.remove(existente);
			transaction.commit();
			return existente;
		} catch (Exception e) {
			if (transaction.isActive())
				transaction.rollback();
			throw new RuntimeException("Erro ao excluir o bairro", e);
		} finally {
			if (transaction.isActive() && !transaction.getRollbackOnly()) {
				transaction.rollback();
			}
		}
	}

	@Override
	public List<Bairro> listAllBairro() throws Exception {
		try {
			String jpql = "SELECT bairro FROM Bairro bairro ORDER BY bairro.bairro ASC";
			return em.createQuery(jpql, Bairro.class).getResultList();
		} catch (Exception e) {
			throw new Exception("Erro ao listar todos os bairros", e);
		}
	}

	@Override
	public Bairro readByIdBairro(Long id) throws Exception {
		if (id == null) {
			throw new IllegalArgumentException("ID do bairro não pode ser nulo");
		}
		try {
			Bairro bairro = em.find(Bairro.class, id);
			if (bairro == null) {
				throw new EntityNotFoundException("Bairro com ID " + id + " não encontrado");
			}
			return bairro;
		} catch (Exception e) {
			throw new Exception("Erro ao buscar bairro por ID", e);
		}
	}

	@Override
	public List<Bairro> listBairro(String nome) throws Exception {
		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome do bairro não pode ser vazio");
		}
		try {
			String jpql = "SELECT bairro FROM Bairro bairro WHERE LOWER(bairro.nome) LIKE LOWER(:nome) ORDER BY bairro.bairro ASC";
			return em.createQuery(jpql, Bairro.class).setParameter("nome", "%" + nome + "%").getResultList();
		} catch (Exception e) {
			throw new Exception("Erro ao buscar bairros por nome", e);
		}
	}

	@Override
	public List<Bairro> listCep(String cep) throws Exception {
		if (cep == null || cep.trim().isEmpty()) {
			throw new IllegalArgumentException("CEP não pode ser vazio");
		}
		try {
			String jpql = "SELECT bairro FROM Bairro bairro WHERE bairro.cep = :cep ORDER BY bairro.bairro ASC";
			return em.createQuery(jpql, Bairro.class).setParameter("cep", cep).getResultList();
		} catch (Exception e) {
			throw new Exception("Erro ao buscar bairros por CEP", e);
		}
	}

	@Override
	public long countBairro() throws Exception {
		try {
			String jpql = "SELECT COUNT(bairro) FROM Bairro bairro";
			return em.createQuery(jpql, Long.class).getSingleResult();
		} catch (Exception e) {
			throw new Exception("Erro ao contar bairros", e);
		}
	}
}
