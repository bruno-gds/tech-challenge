package com.grupo16.techchallenge.eletrodomestico.usecase;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.eletrodomestico.domain.LeituraConsumo;
import com.grupo16.techchallenge.eletrodomestico.gateway.LeituraConsumoRepositoryGateway;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RegistrarConsumoUseCase {
	
	@Autowired
	private LeituraConsumoRepositoryGateway leituraConsumoRepositoryGateway;
	
	@Autowired
	private ObterEletrodomesticoUseCase obterEletrodomesticoUseCase;

	public Long registrar(LeituraConsumo leituraConsumo) {
		log.trace("Start leituraConsumo={}", leituraConsumo);
		
		obterEletrodomesticoUseCase.obter(leituraConsumo.getEletrodomestico().getId());
		
		leituraConsumo.setDataHora(LocalDateTime.now());
		Long id = leituraConsumoRepositoryGateway.salvar(leituraConsumo);
		
		log.trace("End id={}", id);
		return id;
	}

}
