package com.grupo16.techchallenge.eletrodomestico.gateway.repository.jpa.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo16.techchallenge.eletrodomestico.gateway.repository.jpa.entity.LeituraConsumoEntity;

public interface LeituraConsumoRepository extends JpaRepository<LeituraConsumoEntity, Long> {

	List<LeituraConsumoEntity> findByEletrodomesticoIdAndDataHoraBetweenOrderByDataHoraDesc(Long eletrodomesticoId, LocalDateTime dataInicio,
			LocalDateTime dataFim);


}
