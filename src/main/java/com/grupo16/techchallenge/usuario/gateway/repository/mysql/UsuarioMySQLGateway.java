package com.grupo16.techchallenge.usuario.gateway.repository.mysql;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupo16.techchallenge.usuario.domain.Usuario;
import com.grupo16.techchallenge.usuario.gateway.UsuarioRepositoryGateway;
import com.grupo16.techchallenge.usuario.gateway.exception.ErrorToAccessDatabaseException;
import com.grupo16.techchallenge.usuario.gateway.repository.jpa.entity.UsuarioEntity;
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
			
			UsuarioEntity entity = new UsuarioEntity(usuario);
			
			Long usuarioId = usuarioRepository.save(entity).getId();
			
			log.trace("End usuarioId={}", usuarioId);
			return usuarioId;
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErrorToAccessDatabaseException();
		}		
	}

	@Override
	public Optional<Usuario> obterByCpf(String cpf) {
		try {
			log.trace("Start cpf={}", cpf);
			Optional<Usuario> usuarioOp = Optional.empty();
			
			Optional<UsuarioEntity> entity = usuarioRepository.findByCpf(cpf);
			if(entity.isEmpty()) {
				return usuarioOp;
			}

			Usuario usuario = entity.get().mapearUsuarioEntityParaDomain();
			usuarioOp = Optional.of(usuario);
			
			log.trace("End usuarioOp={}", usuarioOp);
			return usuarioOp;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErrorToAccessDatabaseException();
		}
		
	}

}
