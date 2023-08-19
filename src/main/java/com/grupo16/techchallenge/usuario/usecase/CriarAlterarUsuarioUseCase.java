package com.grupo16.techchallenge.usuario.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.usuario.domain.Usuario;
import com.grupo16.techchallenge.usuario.gateway.UsuarioRepositoryGateway;
import com.grupo16.techchallenge.usuario.usecase.exception.CpfJaCadastradoException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CriarAlterarUsuarioUseCase {
	
	@Autowired
	private UsuarioRepositoryGateway usuarioRepository;

	public Long criar(Usuario usuario) {
		log.trace("Start usuario={}", usuario);
		
		Optional<Usuario> usuarioOp = usuarioRepository.obterByCpf(usuario.getCpf());
		if(usuarioOp.isPresent()) {
			log.warn("CPF já cadastrado: {}", usuario.getCpf());
			throw new CpfJaCadastradoException();
		}
		
		Long usuarioId = usuarioRepository.salvar(usuario);
		
		log.trace("End usuarioId={}", usuarioId);
		return usuarioId;
	}
}
