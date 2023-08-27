package com.grupo16.techchallenge.eletrodomestico.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class LeituraConsumo {
	
	private Long id;
	@Setter
	private LocalDateTime dataHora;
	private Double consumo;//TODO: alterar para BigDecimal
	
	private Eletrodomestico eletrodomestico;

}
