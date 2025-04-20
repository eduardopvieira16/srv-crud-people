package br.com.software.epv.srv.crud.people.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.software.epv.srv.crud.people.entities.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long>{
}