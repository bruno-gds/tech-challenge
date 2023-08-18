package com.grupo16.techchallenge.usuario.gateway;

import java.util.Optional;

import com.grupo16.techchallenge.usuario.domain.Usuario;

public interface UserRepositoryGateway {
	
	public Long create(Usuario user);

	public Optional<Usuario> getByCpf(String cpf);

}
