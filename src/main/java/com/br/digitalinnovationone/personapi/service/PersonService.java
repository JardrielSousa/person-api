package com.br.digitalinnovationone.personapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.digitalinnovationone.personapi.dto.MessageResponseDTO;
import com.br.digitalinnovationone.personapi.dto.request.PersonDTO;
import com.br.digitalinnovationone.personapi.entities.Person;
import com.br.digitalinnovationone.personapi.exception.PersonNotFoundException;
import com.br.digitalinnovationone.personapi.mapper.PersonMapper;
import com.br.digitalinnovationone.personapi.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;	
	
	private PersonMapper personMapper = new PersonMapper();
	ModelMapper mapper = new ModelMapper();
	
	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		Person personSaved = personRepository.save(convertToPerson(personDTO));
		return MessageResponseDTO.builder().message("Created person with ID " + personSaved.getId()).build();
	}
	
	public List<PersonDTO> getAllPersons(){
		List<Person> persons = personRepository.findAll();
		return persons.stream().map(person->personMapper.convertToPersonDTO(person)).collect(Collectors.toList());
	}
	
	private Person convertToPerson(PersonDTO personDTO) {
		Person personToSave = mapper.map(personDTO, Person.class);
		personToSave.setBirthDate(personDTO.getBirthDate());
		return personToSave;
	}
	
	public PersonDTO findById(Long id) throws PersonNotFoundException {
		Person person = personRepository.findById(id).orElseThrow(()->new PersonNotFoundException(id));
		return personMapper.convertToPersonDTO(person);
	}
}
