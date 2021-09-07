package com.br.digitalinnovationone.personapi.service;

import java.util.List;
import java.util.stream.Collectors;

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

	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		Person personSaved = personRepository.save(personMapper.convertToPerson(personDTO));
		return createMethodResponse(personSaved.getId(),"Created person with ID ");
	}

	public List<PersonDTO> getAllPersons() {
		List<Person> persons = personRepository.findAll();
		return persons.stream().map(person -> personMapper.convertToPersonDTO(person)).collect(Collectors.toList());
	}

	public PersonDTO findById(Long id) throws PersonNotFoundException {
		Person person = verifyIfExists(id);
		return personMapper.convertToPersonDTO(person);
	}

	public void deleteById(Long id) throws PersonNotFoundException {
		verifyIfExists(id);
		personRepository.deleteById(id);
	}

	private Person verifyIfExists(Long id) throws PersonNotFoundException {
		return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
	}

	public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
		verifyIfExists(id);
		Person personUpdate = personRepository.save(personMapper.convertToPerson(personDTO));
		return createMethodResponse(personUpdate.getId(),"Updated person with ID ");
	}

	private MessageResponseDTO createMethodResponse(Long id,String message) {
		return MessageResponseDTO.builder().message(message + id).build();
	}
}
