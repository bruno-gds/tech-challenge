package com.grupo16.techchallenge.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.techchallenge.person.controller.json.PersonJson;
import com.grupo16.techchallenge.person.domain.Person;
import com.grupo16.techchallenge.person.repository.PersonRepository;

import jakarta.validation.Valid;

@RequestMapping("/people")
@RestController
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;

	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity create(
			@Valid @RequestBody PersonJson personJson) {
		
		Person person = personJson.toPerson();
		
		personRepository.create(person);
		
		//TODO implementar: Validações e repository
		
		return ResponseEntity.status(HttpStatus.CREATED).body("");
	}
}
