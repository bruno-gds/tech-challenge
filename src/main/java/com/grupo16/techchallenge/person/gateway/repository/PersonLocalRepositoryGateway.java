package com.grupo16.techchallenge.person.gateway.repository;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.grupo16.techchallenge.person.domain.Person;
import com.grupo16.techchallenge.person.gateway.PersonRepositoryGateway;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class PersonLocalRepositoryGateway implements PersonRepositoryGateway {
	private Long sequenceId = 1L;
	
	Set<Person> people;

	public PersonLocalRepositoryGateway() {
		this.people = new HashSet<>();
	}

	@Override
	public Long create(Person person) {
		log.trace("Start person={}", person);
		person.setId(sequenceId++);
		
		boolean isCreated = people.add(person);
		if(!isCreated) {
			log.info("Pessoa já existe na base. CPF {}", person.getCpf());
			sequenceId--;
		}
		
		Long personId = person.getId();
		
		log.trace("End personId={}", personId);
		return personId;
	}

}
