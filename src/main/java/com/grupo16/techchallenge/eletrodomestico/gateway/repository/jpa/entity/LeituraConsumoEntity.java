package com.grupo16.techchallenge.eletrodomestico.gateway.repository.jpa.entity;

import java.time.LocalDateTime;

import com.grupo16.techchallenge.eletrodomestico.domain.LeituraConsumo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "LeituraConsumo")
public class LeituraConsumoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime dataHora;
	private Double consumo;

	@ManyToOne
	@JoinColumn(name = "Eletrodomestico_id")
	private EletrodomesticoEntity eletrodomestico;


	public LeituraConsumoEntity(LeituraConsumo leituraConsumo) {
		this.id = leituraConsumo.getId();
		this.dataHora = leituraConsumo.getDataHora();
		this.consumo = leituraConsumo.getConsumo();
		this.eletrodomestico = EletrodomesticoEntity.builder()
				.id(leituraConsumo.getEletrodomestico().getId())
				.build();
	}

	public LeituraConsumo mapToDomain() {
		return LeituraConsumo.builder()
				.id(id)
				.dataHora(dataHora)
				.consumo(consumo)
				.build();
	}

}
