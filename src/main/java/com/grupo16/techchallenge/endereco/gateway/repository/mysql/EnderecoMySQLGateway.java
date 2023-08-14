package com.grupo16.techchallenge.endereco.gateway.repository.mysql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupo16.techchallenge.endereco.domain.Endereco;
import com.grupo16.techchallenge.endereco.gateway.EnderecoRepositoryGateway;
import com.grupo16.techchallenge.endereco.gateway.exception.ErrorToAccessDatabaseException;
import com.grupo16.techchallenge.endereco.gateway.repository.jpa.entity.EnderecoEntity;
import com.grupo16.techchallenge.endereco.gateway.repository.jpa.repository.EnderecoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class EnderecoMySQLGateway implements EnderecoRepositoryGateway {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Override
	public Long criar(Endereco endereco) {		
		try {
			log.trace("Start endereco={}", endereco);
			
			EnderecoEntity entity = new EnderecoEntity(endereco);
			
			enderecoRepository.save(entity);
			
			log.trace("End id={}", entity.getId());
			return entity.getId();
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErrorToAccessDatabaseException();
		}
	}

	@Override
	public List<Endereco> obterTodosByIdUsuario(Long idUsuario) {
		try {
			log.trace("Start idUsuario={}", idUsuario);
			
			List<EnderecoEntity> entities = enderecoRepository.findByUsuarioId(idUsuario);
			
			List<Endereco> enderecos = entities.stream().map(EnderecoEntity::obterEndereco).toList();
			
			log.trace("End enderecos={}", enderecos);
			return enderecos;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErrorToAccessDatabaseException();
		}
		
	}
}
