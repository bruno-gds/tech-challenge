package com.grupo16.techchallenge.eletrodomestico.usecase;

import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;
import com.grupo16.techchallenge.eletrodomestico.gateway.EletrodomesticoRepositoryGateway;
import com.grupo16.techchallenge.eletrodomestico.usecase.exception.EletrodomesticoNaoEncontradoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 21/08/2023
 * Project Name: tech-challenge
 */

@Slf4j
@Service
public class ObterEletrodomesticoUseCase {

    @Autowired
    private EletrodomesticoRepositoryGateway eletrodomesticoRepository;

    public Eletrodomestico obter(Long id) {
        log.trace("Start id={}", id);

        Optional<Eletrodomestico> eletrodomesticoOp = eletrodomesticoRepository.obter(id);
        checarSeEletrodomesticoFoiEncontrado(eletrodomesticoOp);

        log.trace("End eletrodomestico={}", eletrodomesticoOp.get());

        return eletrodomesticoOp.get();
    }

    private void checarSeEletrodomesticoFoiEncontrado(Optional<Eletrodomestico> eletrodomesticoOp) {
        if(eletrodomesticoOp.isEmpty()) {
            log.warn("Eletrodomestico não encontrado.");
            throw new EletrodomesticoNaoEncontradoException();
        }
    }
}
