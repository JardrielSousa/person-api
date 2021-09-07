package com.br.digitalinnovationone.personapi.mapper;

import org.modelmapper.ModelMapper;

import com.br.digitalinnovationone.personapi.dto.request.PersonDTO;
import com.br.digitalinnovationone.personapi.entities.Person;

public class PersonMapper {
	
	ModelMapper mapper = new ModelMapper();
	
	public Person convertToPerson(PersonDTO personDTO) {
		Person person = mapper.map(personDTO, Person.class);
		person.setBirthDate(personDTO.getBirthDate());
		return person;
	}
	
	public PersonDTO convertToPersonDTO(Person person) {
		PersonDTO personDTO = mapper.map(person, PersonDTO.class);
		personDTO.setBirthDate(person.getBirthDate());
		return personDTO;
	}
}
