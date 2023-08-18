package com.grupo16.techchallenge.eletrodomestico.usecase;

import com.grupo16.techchallenge.eletrodomestico.usecase.exception.EletrodomesticoNaoEncontradoException;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;
import com.grupo16.techchallenge.eletrodomestico.gateway.EletrodomesticoRepositoryGateway;
import com.grupo16.techchallenge.eletrodomestico.usecase.exception.IllegalArgumentVoltageException;

@Slf4j
@Service
public class CriarAlterarEletrodomesticoUseCase {

    @Autowired
    private EletrodomesticoRepositoryGateway eletrodomesticoRepository;

    public Long criar(Eletrodomestico eletrodomestico) {
        log.trace("Start eletrodomestico={}", eletrodomestico);

        if (!eletrodomestico.getVoltagem().equals(110L) && !eletrodomestico.getVoltagem().equals(220L)) {
            log.warn("Voltagem inválida: {}", eletrodomestico.getVoltagem());
            throw new IllegalArgumentVoltageException();
        }

        Long eletrodomesticoId = eletrodomesticoRepository.criar(eletrodomestico);

        log.trace("End eletrodomesticoId={}", eletrodomesticoId);
        return eletrodomesticoId;
    }

    public void alterar(Eletrodomestico eletrodomestico) {
        log.trace("Start eletrodomestico={}", eletrodomestico);

        val eletrodomesticoOp = eletrodomesticoRepository
                .obterIdEIdEndereco(
                        eletrodomestico.getId(),
                        eletrodomestico.getEndereco().getId()
                );

        if(eletrodomesticoOp.isEmpty()) throw new EletrodomesticoNaoEncontradoException();

        log.trace("End");
    }
}
