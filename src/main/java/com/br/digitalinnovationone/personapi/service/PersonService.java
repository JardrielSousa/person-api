package com.br.digitalinnovationone.personapi.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.digitalinnovationone.personapi.dto.MessageResponseDTO;
import com.br.digitalinnovationone.personapi.dto.request.PersonDTO;
import com.br.digitalinnovationone.personapi.entities.Person;
import com.br.digitalinnovationone.personapi.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;	
	
	ModelMapper mapper = new ModelMapper();
	
	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		Person personSaved = personRepository.save(convertToPerson(personDTO));
		return MessageResponseDTO.builder().message("Created person with ID " + personSaved.getId()).build();
	}
	
	public List<Person> getAllPersons(){
		return personRepository.findAll();
	}
	
	private Person convertToPerson(PersonDTO personDTO) {
		Person personToSave = mapper.map(personDTO, Person.class);
		personToSave.setBirthDate(personDTO.getBirthDate());
		return personToSave;
	}
}
