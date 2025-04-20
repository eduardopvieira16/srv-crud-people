package br.com.software.epv.srv.crud.people.repositories.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.software.epv.srv.crud.people.entities.PeoplePersonType;
import br.com.software.epv.srv.crud.people.entities.Person;
import br.com.software.epv.srv.crud.people.entities.PersonType;

@Repository
public interface PeoplePersonTypeRepository extends JpaRepository<PeoplePersonType, PeoplePersonType> {
	List<PeoplePersonType> findByPerson(Person person);

	List<PeoplePersonType> findByPersonType(PersonType personType);
}