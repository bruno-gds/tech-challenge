package com.grupo16.techchallenge.eletrodomestico.gateway.repository.mysql;

import com.grupo16.techchallenge.eletrodomestico.gateway.exception.ErrorToAccessDatabaseException;
import com.grupo16.techchallenge.eletrodomestico.gateway.repository.jpa.entity.EletrodomesticoEntity;
import com.grupo16.techchallenge.eletrodomestico.gateway.repository.jpa.repository.EletrodomesticoRepository;
import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;
import com.grupo16.techchallenge.eletrodomestico.gateway.EletrodomesticoRepositoryGateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 15/08/2023
 * Project Name: tech-challenge
 */

@Slf4j
@Repository
public class EletrodomesticoMySQLGateway implements EletrodomesticoRepositoryGateway {

    @Autowired
    private EletrodomesticoRepository eletrodomesticoRepository;

    @Override
    public Long criar(Eletrodomestico eletrodomestico) {
        try {
            log.trace("Start eletrodomestico={}", eletrodomestico);

            EletrodomesticoEntity eletrodomesticoEntity = new EletrodomesticoEntity(eletrodomestico);

            eletrodomesticoRepository.save(eletrodomesticoEntity);

            log.trace("End id={}", eletrodomestico.getId());
            return eletrodomestico.getId();

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ErrorToAccessDatabaseException();
        }
    }
}
