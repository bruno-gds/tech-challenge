package com.grupo16.techchallenge.person.gateway;

import java.util.Optional;

import com.grupo16.techchallenge.person.domain.User;

public interface UserRepositoryGateway {
	
	public Long create(User user);

	public Optional<User> getByCpf(String cpf);

}
