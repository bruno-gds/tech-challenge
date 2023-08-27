package com.grupo16.techchallenge.eletrodomestico.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ConsumoEletrodomesticoParamsDto {
	private Long eletrodomesticoId;
	private LocalDateTime dataInicio;
	private LocalDateTime dataFim;
}
