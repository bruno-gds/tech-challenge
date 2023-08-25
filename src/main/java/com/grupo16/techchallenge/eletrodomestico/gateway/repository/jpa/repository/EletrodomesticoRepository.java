package com.grupo16.techchallenge.eletrodomestico.gateway.repository.jpa.repository;

import com.grupo16.techchallenge.eletrodomestico.gateway.repository.jpa.entity.EletrodomesticoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 15/08/2023
 * Project Name: tech-challenge
 */

public interface EletrodomesticoRepository extends JpaRepository<EletrodomesticoEntity, Long> {

    Optional<EletrodomesticoEntity> findByIdAndEnderecoId(Long id, Long idEndereco);

    @Query("SELECT e FROM EletrodomesticoEntity e WHERE (:nome IS NULL OR e.nome=:nome) AND (:modelo IS NULL OR e.modelo=:modelo ) AND (:marca IS NULL OR e.marca=:marca ) AND (:potencia IS NULL OR e.potencia=:potencia)")
    Optional<List<EletrodomesticoEntity>> buscaFiltrada(
            @Param("nome") String nome,
            @Param("modelo") String modelo,
            @Param("marca") String marca,
            @Param("potencia") Long potencia
    );
}
