package com.grupo16.techchallenge.person.repository;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.grupo16.techchallenge.person.domain.Person;

@Repository
public class PersonRepository {
	private Long sequenceId = 1L;
	
	Set<Person> people;

	public PersonRepository() {
		this.people = new HashSet<>();
	}
	
	public void create(Person person) {
		
		person.setId(sequenceId++); 
		
//		if(people.isEmpty()) {
//			person.setId(sequenceId);
//		} 
//		else {
//			int id = people.size();
//			person.setId(sequenceId + id);
//		}
		
		boolean isCreated = people.add(person);
		if(!isCreated) {
			sequenceId--;
		}
	}
	

}
