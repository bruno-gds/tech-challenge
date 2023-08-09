package com.grupo16.techchallenge.person.gateway;

import java.util.Optional;

import com.grupo16.techchallenge.person.domain.User;

public interface PersonRepositoryGateway {
	
	public Long create(User person);

	public Optional<User> getByCpf(String cpf);

}
