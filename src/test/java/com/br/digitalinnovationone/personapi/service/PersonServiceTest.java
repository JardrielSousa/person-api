package com.br.digitalinnovationone.personapi.service;

import static org.mockito.Mockito.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.br.digitalinnovationone.personapi.dto.MessageResponseDTO;
import com.br.digitalinnovationone.personapi.dto.request.PersonDTO;
import com.br.digitalinnovationone.personapi.entities.Person;
import com.br.digitalinnovationone.personapi.repository.PersonRepository;
import static com.br.digitalinnovationone.personapi.utils.PersonUtils.createFakeDTO;
import static com.br.digitalinnovationone.personapi.utils.PersonUtils.createFakeEntity;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
	
	@Mock
	private PersonRepository personRepository;
	
	@InjectMocks
	private PersonService personService;
	
	@Test
	public void testGivenPersonDTOThenReturnSavedMessage() {
		PersonDTO personDTO = createFakeDTO();
		Person expectedSavedPerson = createFakeEntity();
		
		when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);
		
		MessageResponseDTO expectedSucessMessage = createExpectedSuccessMessage(expectedSavedPerson.getId());
		
		MessageResponseDTO sucessMessage = personService.createPerson(personDTO);
		
		assertEquals(expectedSucessMessage, sucessMessage);
		
	}
	
	private MessageResponseDTO createExpectedSuccessMessage(Long savedPersonId) {
        return MessageResponseDTO.builder()
                .message("Created person with ID " + savedPersonId)
                .build();
    }
}
