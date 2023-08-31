package com.grupo16.techchallenge.usuario.gateway.repository.mysql;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.grupo16.techchallenge.usuario.domain.Parente;
import com.grupo16.techchallenge.usuario.domain.Usuario;
import com.grupo16.techchallenge.usuario.dto.PesquisarUsuarioParamsDto;
import com.grupo16.techchallenge.usuario.gateway.UsuarioRepositoryGateway;
import com.grupo16.techchallenge.usuario.gateway.exception.ErroAoExcluirUsuarioException;
import com.grupo16.techchallenge.usuario.gateway.exception.ErrorToAccessDatabaseException;
import com.grupo16.techchallenge.usuario.gateway.repository.jpa.entity.UsuarioEntity;
import com.grupo16.techchallenge.usuario.gateway.repository.jpa.repository.UsuarioRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UsuarioMySQLGateway implements UsuarioRepositoryGateway {
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Long salvar(Usuario usuario) {
		try {
			log.trace("Start usuario={}", usuario);

			Long usuarioId = null;
			
			if(usuario instanceof Parente) {
				Parente parente = (Parente) usuario;
				
				UsuarioEntity parenteEntity = new UsuarioEntity(parente);
				parenteEntity.setParenteId(parente.getUsuarioPrinpal().getId());
				parenteEntity.setTipoParentesco((long) parente.getParentesco().ordinal());
	
				usuarioId = usuarioRepository.save(parenteEntity).getId();
			} else {
				UsuarioEntity entity = new UsuarioEntity(usuario);
				usuarioId = usuarioRepository.save(entity).getId();
			}
			
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

			Optional<UsuarioEntity> entityOp = usuarioRepository.findByCpf(cpf);
			Optional<Usuario> usuarioOp = checarSeEntityExisteMapearParaDomain(entityOp);
			
			log.trace("End usuarioOp={}", usuarioOp);
			return usuarioOp;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErrorToAccessDatabaseException();
		}
		
	}

	@Override
	public Optional<Usuario> obter(Long id) {
		try {
			log.trace("Start id={}", id);
			
			Optional<UsuarioEntity> entityOp = usuarioRepository.findById(id);
			Optional<Usuario> usuarioOp = checarSeEntityExisteMapearParaDomain(entityOp);
			
			log.trace("End usuarioOp={}", usuarioOp);
			return usuarioOp;
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErrorToAccessDatabaseException();
		}
	}

	@Override
	public void remover(Long id) {
		try {
			log.trace("Start id={}", id);
			
			usuarioRepository.deleteById(id);
			
			log.trace("End");
			
		} catch (DataIntegrityViolationException e) {
			log.error(e.getMessage(), e);
			throw new ErroAoExcluirUsuarioException();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErrorToAccessDatabaseException();
		}
	}
	
	private Optional<Usuario> checarSeEntityExisteMapearParaDomain(Optional<UsuarioEntity> entityOp){
		Optional<Usuario> usuarioOp = Optional.empty();
		if(entityOp.isEmpty()) {
			return usuarioOp;
		}
		usuarioOp = Optional.of(entityOp.get().mapearUsuarioEntityParaDomain());
		
		return usuarioOp;
	}

//	@Override
//	public Long salvar(Parentesco parentesco) {
//		try {
//			//TODO: add logs
//
//			UsuarioEntity parenteEntity = new UsuarioEntity(parentesco.getUsuarioParente());
//			parenteEntity.setParenteId(parentesco.getUsuario().getId());
//			parenteEntity.setTipoParentesco((long) parentesco.getTipoParentesco().ordinal());
//
//			return usuarioRepository.save(parenteEntity).getId();
//			
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new ErrorToAccessDatabaseException();
//		}
//		
//	}

	@Override
	public List<Usuario> pesquisar(PesquisarUsuarioParamsDto paramsDto) {
		try {
			log.trace("Start paramsDto={}", paramsDto);
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			
			CriteriaQuery<UsuarioEntity> criteria = UsuarioCriteriaBuilder.getSQLSearchCriteria(cb, paramsDto);
			
			TypedQuery<UsuarioEntity> query = entityManager.createQuery(criteria);
			
			List<UsuarioEntity> entities = query.getResultList();
			
			List<Usuario> usuarios = entities.stream().map(UsuarioEntity::mapearUsuarioEntityParaDomain).toList();
			
			log.trace("End usuarios={}", usuarios);
			return usuarios;
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErrorToAccessDatabaseException();
		}
	}


}
