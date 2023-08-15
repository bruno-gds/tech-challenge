package com.grupo16.techchallenge.eletrodomestico.gateway.repository.mysql;

import org.springframework.stereotype.Repository;

import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;
import com.grupo16.techchallenge.eletrodomestico.gateway.EletrodomesticoRepositoryGateway;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 15/08/2023
 * Project Name: tech-challenge
 */

@Repository
public class EletrodomesticoMySQLGateway implements EletrodomesticoRepositoryGateway {

    @Override
    public Long criar(Eletrodomestico eletrodomestico) {
        return null;
    }
}
