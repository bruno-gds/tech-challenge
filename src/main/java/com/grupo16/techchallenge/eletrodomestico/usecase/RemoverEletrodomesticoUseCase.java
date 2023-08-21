package com.grupo16.techchallenge.eletrodomestico.usecase;

import com.grupo16.techchallenge.eletrodomestico.gateway.EletrodomesticoRepositoryGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 21/08/2023
 * Project Name: tech-challenge
 */

@Slf4j
@Service
public class RemoverEletrodomesticoUseCase {

    @Autowired
    private EletrodomesticoRepositoryGateway eletrodomesticoRepository;

    public void remover(Long id) {
        log.trace("Start id={}", id);

        eletrodomesticoRepository.remover(id);

        log.trace("End");
    }
}
