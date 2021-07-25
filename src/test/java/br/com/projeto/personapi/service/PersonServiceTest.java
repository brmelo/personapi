package br.com.projeto.personapi.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.projeto.personapi.utils.PersonUtils.createFakeDTO;
import static br.com.projeto.personapi.utils.PersonUtils.createFakeEntity;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;

import br.com.projeto.personapi.dto.request.PersonDTO;
import br.com.projeto.personapi.dto.response.MessageResponseDTO;
import br.com.projeto.personapi.entity.Person;
import br.com.projeto.personapi.repository.PersonRepository;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
	
	@Mock
	private PersonRepository personRepository;
	
	@InjectMocks
	private PersonService personService;
	
	@Test
	void testGivenPersonDTOThenReturnSavedMessage() {
		PersonDTO personDTO = createFakeDTO();
		Person expectedSavedPerson = createFakeEntity();
		
		when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);
		
		MessageResponseDTO expectedSuccessMessage = createdExpectedMessageResponse(expectedSavedPerson.getId());
		MessageResponseDTO successMessage =  personService.createPerson(personDTO);
		
		assertEquals(expectedSuccessMessage, successMessage);
		
	}

	private MessageResponseDTO createdExpectedMessageResponse(Long id) {
		return MessageResponseDTO.builder()
				.message("Created person with ID " + id)
				.build();
	}

}
