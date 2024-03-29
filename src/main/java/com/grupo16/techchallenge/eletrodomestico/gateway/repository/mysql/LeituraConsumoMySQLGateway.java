package com.grupo16.techchallenge.eletrodomestico.gateway.repository.mysql;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupo16.techchallenge.eletrodomestico.domain.LeituraConsumo;
import com.grupo16.techchallenge.eletrodomestico.dto.ConsumoEletrodomesticoParamsDto;
import com.grupo16.techchallenge.eletrodomestico.gateway.LeituraConsumoRepositoryGateway;
import com.grupo16.techchallenge.eletrodomestico.gateway.repository.jpa.entity.LeituraConsumoEntity;
import com.grupo16.techchallenge.eletrodomestico.gateway.repository.jpa.repository.LeituraConsumoRepository;
import com.grupo16.techchallenge.endereco.gateway.exception.ErrorToAccessDatabaseException;

import jakarta.transaction.Transactional;
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

	@Override
	public List<LeituraConsumo> pesquisar(ConsumoEletrodomesticoParamsDto paramsDto) {
		try {
			log.trace("Start paramsDto={}", paramsDto);
			
			
			List<LeituraConsumoEntity> entities = leituraConsumoRepository.findByEletrodomesticoIdAndDataHoraBetweenOrderByDataHoraDesc(
					paramsDto.getEletrodomesticoId(),
					paramsDto.getDataInicio(),
					paramsDto.getDataFim());

			List<LeituraConsumo> domains = entities.stream().map(LeituraConsumoEntity::mapToDomain).toList();
			
			log.trace("End domains={}", domains);
			return domains;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErrorToAccessDatabaseException();			
		}
	}

	@Override
	public Optional<LeituraConsumo> obterUltimaLeituraPorEletrodomesticoId(Long eletrodomesticoId) {
		try {
			log.trace("Start eletrodomesticoId={}", eletrodomesticoId);
			
			Optional<LeituraConsumoEntity> entityOp = leituraConsumoRepository.findFirstByEletrodomesticoIdOrderByDataHoraDesc(eletrodomesticoId);
			
			Optional<LeituraConsumo> domainOp = Optional.empty();
			if(entityOp.isPresent()) {
				LeituraConsumoEntity leituraConsumoEntity = entityOp.get();
				domainOp = Optional.of(leituraConsumoEntity.mapToDomain());
			}
			
			log.trace("End domainOp={}", domainOp);
			return domainOp;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErrorToAccessDatabaseException();			
		}
	}

	@Override
	@Transactional
	public void remover(Long idEletrodomestico) {
		try {
			log.trace("Start idEletrodomestico={}", idEletrodomestico);
			
			leituraConsumoRepository.deleteByEletrodomesticoId(idEletrodomestico);
			
			log.trace("End");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErrorToAccessDatabaseException();
		}
		
	}
	
}
