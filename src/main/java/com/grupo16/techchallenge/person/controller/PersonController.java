package com.grupo16.techchallenge.person.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.techchallenge.person.controller.json.PersonJson;
import com.grupo16.techchallenge.person.domain.Person;

@RequestMapping("/people")
@RestController
public class PersonController {

	@PostMapping
	public ResponseEntity create(@RequestBody PersonJson personJson) {
		
		Person person = personJson.toPerson();
		
		//TODO implementar: Validações e repository
		
		return ResponseEntity.status(HttpStatus.CREATED).body("");
	}
}
