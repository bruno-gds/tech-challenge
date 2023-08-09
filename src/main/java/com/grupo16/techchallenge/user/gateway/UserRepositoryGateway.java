package com.grupo16.techchallenge.user.gateway;

import java.util.Optional;

import com.grupo16.techchallenge.user.domain.User;

public interface UserRepositoryGateway {
	
	public Long create(User user);

	public Optional<User> getByCpf(String cpf);

}
