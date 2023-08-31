package com.grupo16.techchallenge.eletrodomestico.domain;

import java.time.LocalDateTime;
import java.util.List;

import com.grupo16.techchallenge.endereco.domain.Endereco;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Eletrodomestico {

    private Long id;
    private String nome;
    private String modelo;
    private String marca;
    private String cor;
    private Long potencia;
    private Long voltagem;
    private Endereco endereco;
    private List<LeituraConsumo> medicoesConsumo;
	
    public Double getConsumo(LocalDateTime dataInicio, LocalDateTime dataFim) {
    	
    	if(medicoesConsumo.isEmpty()) {
    		return 0D;
    	}
    	
    	Double consumoMenor = medicoesConsumo.stream()
    			.sorted((mc1, mc2) -> mc1.getDataHora().compareTo(mc2.getDataHora()))
    			.filter(mc ->  mc.getDataHora().compareTo(dataInicio) >= 0)
    			.map(LeituraConsumo::getConsumo)
    			.findFirst()
    			.orElseThrow();
    	
    	Double consumoMaior = medicoesConsumo.stream()
    			.sorted((mc1, mc2) -> mc2.getDataHora().compareTo(mc1.getDataHora()))
    			.filter(mc ->  mc.getDataHora().compareTo(dataFim) <= 0)
    			.map(LeituraConsumo::getConsumo)
    			.findAny()
    			.orElseThrow();
    	
		return consumoMaior - consumoMenor;
	}
}
