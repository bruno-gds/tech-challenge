package com.grupo16.techchallenge.usuario.gateway;

import java.util.Optional;

import com.grupo16.techchallenge.usuario.domain.Usuario;

public interface UsuarioRepositoryGateway {
	
	public Long salvar(Usuario user);

	public Optional<Usuario> obterByCpf(String cpf);

}
