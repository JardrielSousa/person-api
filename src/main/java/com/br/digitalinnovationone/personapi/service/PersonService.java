package com.br.digitalinnovationone.personapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.br.digitalinnovationone.personapi.dto.MessageResponseDTO;
import com.br.digitalinnovationone.personapi.entities.Person;
import com.br.digitalinnovationone.personapi.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}

	public MessageResponseDTO createPerson(@RequestBody Person person) {
		Person personSaved = personRepository.save(person);
		return MessageResponseDTO.builder().message("Created person with ID " + personSaved.getId()).build();
	}
	
	public List<Person> getAllPersons(){
		return personRepository.findAll();
	}
}
