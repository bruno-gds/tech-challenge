package com.grupo16.techchallenge.eletrodomestico.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;
import com.grupo16.techchallenge.eletrodomestico.domain.LeituraConsumo;
import com.grupo16.techchallenge.eletrodomestico.dto.ConsumoEletrodomesticoParamsDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ObterConsumoUseCase {
	
	@Autowired
	private PesquisarConsumoEletrodomesticoUseCase pesquisarConsumoEletrodomesticoUseCase;
	
	public Double obter(ConsumoEletrodomesticoParamsDto paramsDto) {
		log.trace("Start paramsDto={}", paramsDto);
		
		List<LeituraConsumo> consumos = pesquisarConsumoEletrodomesticoUseCase.pesquisar(paramsDto);
		
		Eletrodomestico eletrodomestico = Eletrodomestico.builder()
				.id(paramsDto.getEletrodomesticoId())
				.medicoesConsumo(consumos)
				.build();
		
		Double consumo = eletrodomestico.getConsumo(paramsDto.getDataInicio(), paramsDto.getDataFim());
		
		log.trace("End consumo={}", consumo);
		return consumo;
	}

}
