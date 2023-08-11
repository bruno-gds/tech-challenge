package com.grupo16.techchallenge.eletrodomestico.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class MedicaoConsumo {
	
	private Long id;
	private LocalDateTime dataHora;
	private Double consumo;
	
	private Eletrodomestico eletrodomestico;

}
