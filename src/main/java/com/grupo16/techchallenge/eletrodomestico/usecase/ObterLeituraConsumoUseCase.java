package com.grupo16.techchallenge.eletrodomestico.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.eletrodomestico.domain.LeituraConsumo;
import com.grupo16.techchallenge.eletrodomestico.dto.ConsumoEletrodomesticoParamsDto;
import com.grupo16.techchallenge.eletrodomestico.gateway.LeituraConsumoRepositoryGateway;
import com.grupo16.techchallenge.eletrodomestico.usecase.exception.LeituraConsumoNaoEncontradoException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ObterLeituraConsumoUseCase {
	
	@Autowired
	private LeituraConsumoRepositoryGateway leituraConsumoRepositoryGateway;
	
	public List<LeituraConsumo> pesquisar(ConsumoEletrodomesticoParamsDto paramsDto) {
		log.trace("Start paramsDto={}", paramsDto);
		
		List<LeituraConsumo> consumos = leituraConsumoRepositoryGateway.pesquisar(paramsDto);
		
		log.trace("End consumos={}", consumos);
		return consumos;
	}
	
	public LeituraConsumo ultima(ConsumoEletrodomesticoParamsDto paramsDto) {
		log.trace("Start paramsDto={}", paramsDto);
		
		Optional<LeituraConsumo> consumosOp = leituraConsumoRepositoryGateway.obterUltimaLeituraPorEletrodomesticoId(paramsDto.getEletrodomesticoId());
		
		if(consumosOp.isEmpty()) {
			log.warn("Leituras de consumo não encontradas");
			throw new LeituraConsumoNaoEncontradoException();
		}
		
		LeituraConsumo leituraConsumo = consumosOp.get();
		
		log.trace("End leituraConsumo={}", leituraConsumo);
		return leituraConsumo;
	}

}
