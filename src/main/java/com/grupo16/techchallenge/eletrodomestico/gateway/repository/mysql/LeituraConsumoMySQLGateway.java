package com.grupo16.techchallenge.eletrodomestico.gateway.repository.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupo16.techchallenge.eletrodomestico.domain.LeituraConsumo;
import com.grupo16.techchallenge.eletrodomestico.gateway.LeituraConsumoRepositoryGateway;
import com.grupo16.techchallenge.eletrodomestico.gateway.repository.jpa.entity.LeituraConsumoEntity;
import com.grupo16.techchallenge.eletrodomestico.gateway.repository.jpa.repository.LeituraConsumoRepository;
import com.grupo16.techchallenge.endereco.gateway.exception.ErrorToAccessDatabaseException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class LeituraConsumoMySQLGateway implements LeituraConsumoRepositoryGateway {
	
	@Autowired
	private LeituraConsumoRepository leituraConsumoRepository;
	
	@Override
	public Long salvar(LeituraConsumo leituraConsumo) {
		try {
			log.trace("Start leituraConsumo={}", leituraConsumo);
			
			LeituraConsumoEntity leituraEntity = new LeituraConsumoEntity(leituraConsumo);
			
			Long id = leituraConsumoRepository.save(leituraEntity).getId();
			
			log.trace("End id={}", id);
			return id;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErrorToAccessDatabaseException();			
		}
	}
	
}
