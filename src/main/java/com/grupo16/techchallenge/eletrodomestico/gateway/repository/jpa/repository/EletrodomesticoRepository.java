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

    @Query("SELECT eletrodomestico FROM EletrodomesticoEntity eletrodomestico " +
            "INNER JOIN EnderecoEntity endereco ON eletrodomestico.endereco.id = endereco.id " +
            "WHERE endereco.usuario.id = :idUsuario AND " +
            "(:nome IS NULL OR eletrodomestico.nome LIKE %:nome%) AND " +
            "(:modelo IS NULL OR eletrodomestico.modelo LIKE %:modelo% ) AND " +
            "(:marca IS NULL OR eletrodomestico.marca LIKE %:marca% ) AND " +
            "(:potencia IS NULL OR eletrodomestico.potencia=:potencia)")
    List<EletrodomesticoEntity> buscaFiltrada(
            @Param("idUsuario") Long idUsuario,
            @Param("nome") String nome,
            @Param("modelo") String modelo,
            @Param("marca") String marca,
            @Param("potencia") Long potencia
    );
}
