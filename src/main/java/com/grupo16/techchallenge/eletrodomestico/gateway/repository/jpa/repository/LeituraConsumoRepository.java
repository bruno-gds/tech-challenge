package com.grupo16.techchallenge.eletrodomestico.gateway.repository.jpa.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo16.techchallenge.eletrodomestico.gateway.repository.jpa.entity.LeituraConsumoEntity;

public interface LeituraConsumoRepository extends JpaRepository<LeituraConsumoEntity, Long> {

	List<LeituraConsumoEntity> findByEletrodomesticoIdAndDataHoraBetweenOrderByDataHoraDesc(Long eletrodomesticoId, LocalDateTime dataInicio,
			LocalDateTime dataFim);

	Optional<LeituraConsumoEntity> findFirstByEletrodomesticoIdOrderByDataHoraDesc(Long eletrodomesticoId);

	void deleteByEletrodomesticoId(Long idEletrodomestico);


}
