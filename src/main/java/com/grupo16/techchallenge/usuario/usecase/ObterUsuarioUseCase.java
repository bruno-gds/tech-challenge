package com.grupo16.techchallenge.usuario.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.usuario.domain.Usuario;
import com.grupo16.techchallenge.usuario.gateway.UsuarioRepositoryGateway;
import com.grupo16.techchallenge.usuario.usecase.exception.UsuarioNaoEncontradoException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ObterUsuarioUseCase {
	
	@Autowired
	private UsuarioRepositoryGateway usuarioRepository;

	public Usuario obterByCpf(String cpf) {
		log.trace("Start cpf={}", cpf);
		
		Optional<Usuario> usuarioOp = usuarioRepository.obterByCpf(cpf);
		if(usuarioOp.isEmpty()) {
			log.warn("Usuário não encontrado. CPF={}", cpf);
			throw new UsuarioNaoEncontradoException();
		}
		
		log.trace("End usuario={}", usuarioOp.get());
		return usuarioOp.get();
	}

	public Usuario obter(Long id) {
		log.trace("Start id={}", id);
		
		Optional<Usuario> usuarioOp = usuarioRepository.obter(id);
		if(usuarioOp.isEmpty()) {
			log.warn("Usuário não encontrado. id={}", id);
			throw new UsuarioNaoEncontradoException();
		}
		
		log.trace("Start usuario={}", usuarioOp.get());
		return usuarioOp.get();
	}
}
