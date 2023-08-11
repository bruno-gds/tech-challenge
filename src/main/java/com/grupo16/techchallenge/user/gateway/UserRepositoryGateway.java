package com.grupo16.techchallenge.user.gateway;

import java.util.Optional;

import com.grupo16.techchallenge.user.domain.Usuario;

public interface UserRepositoryGateway {
	
	public Long create(Usuario user);

	public Optional<Usuario> getByCpf(String cpf);

}
