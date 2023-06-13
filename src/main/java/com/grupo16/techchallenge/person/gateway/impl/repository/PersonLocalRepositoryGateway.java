package com.grupo16.techchallenge.person.gateway.impl.repository;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.grupo16.techchallenge.person.domain.Person;
import com.grupo16.techchallenge.person.gateway.PersonRepositoryGateway;

@Repository
public class PersonLocalRepositoryGateway implements PersonRepositoryGateway {
	private Long sequenceId = 1L;
	
	Set<Person> people;

	public PersonLocalRepositoryGateway() {
		this.people = new HashSet<>();
	}

	@Override
	public Long create(Person person) {
		person.setId(sequenceId++);
		
		boolean isCreated = people.add(person);
		if(!isCreated) {
			sequenceId--;
		}
		
		return person.getId();
	}

}
