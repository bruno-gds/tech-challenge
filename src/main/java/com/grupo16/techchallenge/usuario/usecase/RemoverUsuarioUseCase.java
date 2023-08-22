package com.grupo16.techchallenge.usuario.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.usuario.domain.Usuario;
import com.grupo16.techchallenge.usuario.gateway.UsuarioRepositoryGateway;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RemoverUsuarioUseCase {
	
	@Autowired
	private UsuarioRepositoryGateway usuarioRepository;

	@Autowired
	private ObterUsuarioUseCase obterUsuarioUseCase;

	public void remover(Long id) {
		log.trace("Start id={}", id);
		
		Usuario usuario = obterUsuarioUseCase.obter(id);
		usuarioRepository.remover(usuario.getId());
		
		log.trace("End");
	}

}
