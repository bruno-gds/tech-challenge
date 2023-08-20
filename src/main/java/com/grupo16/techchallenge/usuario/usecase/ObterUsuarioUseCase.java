package com.grupo16.techchallenge.usuario.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.usuario.domain.Usuario;
import com.grupo16.techchallenge.usuario.gateway.UsuarioRepositoryGateway;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ObterUsuarioUseCase {
	
	@Autowired
	private UsuarioRepositoryGateway usuarioRepository;

	public Usuario obterByCpf(String cpf) {
		log.trace("Start cpf={}", cpf);
		
		
		
				
		log.trace("End usuario={}");
		return null;
	}
}
