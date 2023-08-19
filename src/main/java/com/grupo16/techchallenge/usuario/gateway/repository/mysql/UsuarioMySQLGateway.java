package com.grupo16.techchallenge.usuario.gateway.repository.mysql;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupo16.techchallenge.usuario.domain.Usuario;
import com.grupo16.techchallenge.usuario.gateway.UsuarioRepositoryGateway;
import com.grupo16.techchallenge.usuario.gateway.exception.ErrorToAccessDatabaseException;
import com.grupo16.techchallenge.usuario.gateway.repository.jpa.repository.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UsuarioMySQLGateway implements UsuarioRepositoryGateway {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Long salvar(Usuario usuario) {
		try {
			log.trace("Start usuario={}", usuario);
			
			//TODO: implementar
			
			log.trace("End usuarioId={}");
			return null;
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErrorToAccessDatabaseException();
		}		
	}

	@Override
	public Optional<Usuario> obterByCpf(String cpf) {
		try {
			log.trace("Start cpf={}", cpf);
			
			//TODO: implementar
			
			log.trace("End usuarioOp={}");
			return null;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErrorToAccessDatabaseException();
		}
		
	}

}
