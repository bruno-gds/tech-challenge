package com.grupo16.techchallenge.eletrodomestico.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;
import com.grupo16.techchallenge.eletrodomestico.domain.LeituraConsumo;
import com.grupo16.techchallenge.eletrodomestico.dto.ConsumoEletrodomesticoParamsDto;
import com.grupo16.techchallenge.eletrodomestico.usecase.exception.LeituraConsumoNaoEncontradoException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ObterConsumoUseCase {
	
	@Autowired
	private ObterLeituraConsumoUseCase pesquisarConsumoEletrodomesticoUseCase;
	
	public Double obter(ConsumoEletrodomesticoParamsDto paramsDto) {
		log.trace("Start paramsDto={}", paramsDto);
		
		Double consumo = 0D;
		
		if(paramsDto.hasPeriodDate()) {
			consumo = getConsumoPorPeriodo(paramsDto);
		} else {
			consumo = getUltimoConsumo(paramsDto, consumo);
		}
		
		log.trace("End consumo={}", consumo);
		return consumo;
	}

	private Double getUltimoConsumo(ConsumoEletrodomesticoParamsDto paramsDto, Double consumo) {
		try {
			consumo = pesquisarConsumoEletrodomesticoUseCase.ultima(paramsDto).getConsumo();
		} catch (LeituraConsumoNaoEncontradoException e) {
			log.warn("Leitura não encontrada. Usando valor de consumo 0");
		}
		return consumo;
	}

	private Double getConsumoPorPeriodo(ConsumoEletrodomesticoParamsDto paramsDto) {
		Double consumo;
		List<LeituraConsumo> consumos = pesquisarConsumoEletrodomesticoUseCase.pesquisar(paramsDto);
		
		Eletrodomestico eletrodomestico = Eletrodomestico.builder()
				.id(paramsDto.getEletrodomesticoId())
				.medicoesConsumo(consumos)
				.build();
		
		consumo = eletrodomestico.getConsumo(paramsDto.getDataInicio(), paramsDto.getDataFim());
		return consumo;
	}

}
