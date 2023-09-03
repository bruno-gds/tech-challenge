package com.grupo16.techchallenge.eletrodomestico.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.eletrodomestico.gateway.LeituraConsumoRepositoryGateway;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RemoverRegistroConsumoUseCase {
	
	@Autowired
	private LeituraConsumoRepositoryGateway leituraConsumoRepositoryGateway;
	
	@Autowired
	private ObterEletrodomesticoUseCase obterEletrodomesticoUseCase;

	public void remover(Long idEletrodomestico, Long idUsuario) {
		log.trace("Start idEletrodomestico={}, idUsuario={}", idEletrodomestico, idUsuario);
		
		obterEletrodomesticoUseCase.obterPeloIdAndUsuarioId(idEletrodomestico, idUsuario);
		
		leituraConsumoRepositoryGateway.remover(idEletrodomestico);
		
		log.trace("End");
	}

}
