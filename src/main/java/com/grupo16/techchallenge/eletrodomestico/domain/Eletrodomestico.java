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
	
    //TODO: ideal seria trabalhar com BigDecimal ao invés de Double
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
    
    //TESTE
//    public static void main(String[] args) {
//    	
//    	List<LeituraConsumo> medicoesConsumo = Arrays.asList(
//    			LeituraConsumo.builder().consumo(1D).dataHora(LocalDateTime.of(2023, Month.AUGUST, 3, 0, 0)) .build(),
//    			LeituraConsumo.builder().consumo(2D).dataHora(LocalDateTime.of(2023, Month.AUGUST, 4, 0, 0)) .build(),//MENOR
//    			LeituraConsumo.builder().consumo(3D).dataHora(LocalDateTime.of(2023, Month.AUGUST, 5, 0, 0)) .build(),
//    			LeituraConsumo.builder().consumo(4D).dataHora(LocalDateTime.of(2023, Month.AUGUST, 6, 0, 0)) .build(),//MAIOR
//    			LeituraConsumo.builder().consumo(5D).dataHora(LocalDateTime.of(2023, Month.AUGUST, 6, 0, 1)) .build());
//    	
//    	
//    	Eletrodomestico eletrodomestico = new Eletrodomestico();
//    	eletrodomestico.medicoesConsumo = medicoesConsumo;
//    	
//    	LocalDateTime inicio = LocalDateTime.of(2023, Month.AUGUST, 4, 0, 0);
//    	LocalDateTime fim = LocalDateTime.of(2023, Month.AUGUST, 6, 0, 0);
//    	
//    	Double consumo = eletrodomestico.getConsumo(inicio, fim);
//	}
    
}
