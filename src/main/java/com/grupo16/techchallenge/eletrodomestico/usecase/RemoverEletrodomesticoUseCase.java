package com.grupo16.techchallenge.eletrodomestico.usecase;

import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;
import com.grupo16.techchallenge.eletrodomestico.gateway.EletrodomesticoRepositoryGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RemoverEletrodomesticoUseCase {

    @Autowired
    private EletrodomesticoRepositoryGateway eletrodomesticoRepository;

    @Autowired
    private ObterEletrodomesticoUseCase obterEletrodomesticoUseCase;

    public void remover(Long eletrodomesticoId, Long usuarioId) {
        log.trace("Start eletrodomesticoId={}, usuarioId={}", eletrodomesticoId, usuarioId);
        
        Eletrodomestico eletrodomestico = obterEletrodomesticoUseCase.obterPeloIdAndUsuarioId(eletrodomesticoId, usuarioId);
        
        eletrodomesticoRepository.remover(eletrodomestico.getId());

        log.trace("End");
    }
}
