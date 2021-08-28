package com.br.digitalinnovationone.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.digitalinnovationone.personapi.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
