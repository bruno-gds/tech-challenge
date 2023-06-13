package com.grupo16.techchallenge.person.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.person.domain.Person;
import com.grupo16.techchallenge.person.gateway.PersonRepositoryGateway;

@Service
public class PersonUseCase {
	
	@Autowired
	private PersonRepositoryGateway personRepository;

	public Long create(Person person) {
		return personRepository.create(person);
	}
	
	

}
