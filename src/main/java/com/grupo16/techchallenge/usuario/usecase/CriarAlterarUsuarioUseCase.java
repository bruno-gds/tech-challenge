package com.grupo16.techchallenge.usuario.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.usuario.domain.Usuario;
import com.grupo16.techchallenge.usuario.gateway.UserRepositoryGateway;
import com.grupo16.techchallenge.usuario.usecase.exception.CpfAlreadyRegisteredException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CriarAlterarUsuarioUseCase {
	
	@Autowired
	private UserRepositoryGateway userRepository;

	public Long criar(Usuario usuario) {
		log.trace("Start usuario={}", usuario);
		
		Optional<Usuario> usuarioOp = userRepository.getByCpf(usuario.getCpf());
		if(usuarioOp.isPresent()) {
			log.warn("CPF já cadastrado: {}", usuario.getCpf());
			throw new CpfAlreadyRegisteredException();
		}
		
		Long usuarioId = userRepository.create(usuario);
		
		log.trace("End usuarioId={}", usuarioId);
		return usuarioId;
	}
}
