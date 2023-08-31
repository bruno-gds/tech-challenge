package com.grupo16.techchallenge.eletrodomestico.usecase;

import com.grupo16.techchallenge.eletrodomestico.gateway.EletrodomesticoRepositoryGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
