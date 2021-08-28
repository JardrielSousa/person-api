package com.br.digitalinnovationone.personapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.digitalinnovationone.personapi.dto.MessageResponseDTO;
import com.br.digitalinnovationone.personapi.entities.Person;
import com.br.digitalinnovationone.personapi.repository.PersonRepository;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

	private PersonRepository personRepository;
	
	public PersonController(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}

	@PostMapping
	public MessageResponseDTO createPerson(@RequestBody Person person) {
		Person personSaved = personRepository.save(person);
		return MessageResponseDTO.builder().message("Created person with ID " + personSaved.getId()).build();
	}
	
	@GetMapping
	public List<Person> getAllPersons(){
		return personRepository.findAll();
	}
}
