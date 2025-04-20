package br.com.software.epv.srv.crud.people.repositories.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.software.epv.srv.crud.people.entities.Person;

@Repository
public interface PersonTypeRepositoryImpl extends JpaRepository<Person, Long> {
}