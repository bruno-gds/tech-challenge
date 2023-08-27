package com.grupo16.techchallenge.eletrodomestico.controller.json;

import com.grupo16.techchallenge.eletrodomestico.domain.LeituraConsumo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeituraConsumoJson {
	
	private Long id;

	@NotNull
	private Double consumo;
	
	public LeituraConsumoJson(LeituraConsumo leituraConsumo) {
		id = leituraConsumo.getId();
		consumo = leituraConsumo.getConsumo();
	}

}
