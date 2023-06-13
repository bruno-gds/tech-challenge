package com.grupo16.techchallenge.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.techchallenge.person.controller.json.PersonJson;
import com.grupo16.techchallenge.person.domain.Person;
import com.grupo16.techchallenge.person.usecase.PersonUseCase;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/people")
@RestController
public class PersonController {
	
	@Autowired
	private PersonUseCase personUseCase;

	@PostMapping
	public Long create(
			@Valid @RequestBody PersonJson personJson) {
		log.trace("Start personJson={}", personJson);
		
		Person person = personJson.toPerson();
		
		personUseCase.create(person);
		
//		personRepository.create(person);

		Long personId = person.getId(); 
		log.trace("End personId={}", personId);
		return personId;
	}
}
