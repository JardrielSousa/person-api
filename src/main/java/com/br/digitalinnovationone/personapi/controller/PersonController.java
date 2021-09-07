package com.br.digitalinnovationone.personapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.digitalinnovationone.personapi.dto.MessageResponseDTO;
import com.br.digitalinnovationone.personapi.dto.request.PersonDTO;
import com.br.digitalinnovationone.personapi.exception.PersonNotFoundException;
import com.br.digitalinnovationone.personapi.service.PersonService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {
	private final PersonService personService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
		return personService.createPerson(personDTO);
	}
	
	@GetMapping
	public List<PersonDTO> getAllPersons(){
		return personService.getAllPersons();
	}
	
	@GetMapping("/{id}")
	public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
		return personService.findById(id);
	}
	
	@PutMapping("/{id}")
	public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody PersonDTO personDTO) throws PersonNotFoundException {
		return personService.updateById(id,personDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteByID(@PathVariable Long id) throws PersonNotFoundException{
		 personService.deleteById(id);
	}
}
