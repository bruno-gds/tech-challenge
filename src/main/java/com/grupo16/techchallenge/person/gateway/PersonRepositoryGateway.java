package com.grupo16.techchallenge.person.gateway;

import java.util.Optional;

import com.grupo16.techchallenge.person.domain.Person;

public interface PersonRepositoryGateway {
	
	public Long create(Person person);

	public Optional<Person> getByCpf(String cpf);

}
