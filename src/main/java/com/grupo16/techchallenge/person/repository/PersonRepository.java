package com.grupo16.techchallenge.person.repository;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.grupo16.techchallenge.person.domain.Person;

@Repository
public class PersonRepository {
	
	Set<Person> people;

	public PersonRepository() {
		this.people = new HashSet<>();
	}
	
	public void create(Person person) {
		people.add(person);
	}

}
