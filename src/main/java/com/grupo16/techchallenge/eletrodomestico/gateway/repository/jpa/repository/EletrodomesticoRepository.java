package com.grupo16.techchallenge.eletrodomestico.gateway.repository.jpa.repository;

import com.grupo16.techchallenge.eletrodomestico.gateway.repository.jpa.entity.EletrodomesticoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 15/08/2023
 * Project Name: tech-challenge
 */

public interface EletrodomesticoRepository extends JpaRepository<EletrodomesticoEntity, Long> {
}
