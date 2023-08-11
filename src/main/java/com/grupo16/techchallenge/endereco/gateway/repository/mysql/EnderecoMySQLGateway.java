package com.grupo16.techchallenge.endereco.gateway.repository.mysql;

import org.springframework.stereotype.Repository;

import com.grupo16.techchallenge.endereco.domain.Endereco;
import com.grupo16.techchallenge.endereco.gateway.EnderecoRepositoryGateway;
import com.grupo16.techchallenge.endereco.gateway.exception.ErrorToAccessDatabaseException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class EnderecoMySQLGateway implements EnderecoRepositoryGateway {
	
	@Override
	public Long criar(Endereco endereco) {		
		try {
			log.trace("Start endereco={}", endereco);
			
//			log.trace("End id={}", id);
			return null;
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErrorToAccessDatabaseException();
		}
	}
}
