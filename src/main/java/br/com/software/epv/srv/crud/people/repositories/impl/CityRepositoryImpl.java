package br.com.software.epv.srv.crud.people.repositories.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.software.epv.srv.crud.people.entities.City;

@Repository
public interface CityRepositoryImpl extends JpaRepository<City, Long> {

}