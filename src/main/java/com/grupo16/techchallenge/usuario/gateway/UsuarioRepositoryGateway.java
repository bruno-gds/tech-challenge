package com.grupo16.techchallenge.usuario.gateway;

import java.util.Optional;

import com.grupo16.techchallenge.usuario.domain.Parentesco;
import com.grupo16.techchallenge.usuario.domain.Usuario;

public interface UsuarioRepositoryGateway {
	
	public Long salvar(Usuario user);

	public Long salvar(Parentesco parentesco);

	public Optional<Usuario> obterByCpf(String cpf);

	public Optional<Usuario> obter(Long id);

	public void remover(Long id);

}
