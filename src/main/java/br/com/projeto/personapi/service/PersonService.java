package br.com.projeto.personapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.personapi.dto.request.PersonDTO;
import br.com.projeto.personapi.dto.response.MessageResponseDTO;
import br.com.projeto.personapi.entity.Person;
import br.com.projeto.personapi.repository.PersonRepository;

@Service
public class PersonService {

	private PersonRepository personRepository;
	
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		Person personToSave = Person.builder()
				.firstName(personDTO.getFirstName())
				.lastName(personDTO.getLastName())
				.birthDate(personDTO.getBirthDate())
				.phones(personDTO.getPhones())
				.build();
				
		Person savedPerson = personRepository.save(personDTO);
		return MessageResponseDTO.builder().message("Created person with ID " + savedPerson.getId()).build();
	}
}
