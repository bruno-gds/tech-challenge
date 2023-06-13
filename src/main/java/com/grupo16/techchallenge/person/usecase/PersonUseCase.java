package com.grupo16.techchallenge.person.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.person.domain.Person;
import com.grupo16.techchallenge.person.gateway.PersonRepositoryGateway;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PersonUseCase {
	
	@Autowired
	private PersonRepositoryGateway personRepository;

	public Long create(Person person) {
		log.trace("Start person={}", person);
		
		Long personId = personRepository.create(person);
		
		log.trace("End personId={}", personId);
		return personId;
	}
}
