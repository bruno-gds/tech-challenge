package com.grupo16.techchallenge.person.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.person.domain.Person;
import com.grupo16.techchallenge.person.repository.PersonRepository;

@Service
public class PersonUseCase {
	
	@Autowired
	private PersonRepository personRepository;

	public void create(Person person) {
		// TODO Auto-generated method stub
		
	}
	
	

}
