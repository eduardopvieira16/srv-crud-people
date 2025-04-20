package br.com.software.epv.srv.crud.people.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.software.epv.srv.crud.people.entities.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}