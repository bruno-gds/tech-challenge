package com.grupo16.techchallenge.eletrodomestico.controller.json;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class LeituraConsumoJson {
	
	private Long id;

	@NotNull
	private Double leituraConsumo;
	

}
