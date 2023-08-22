package com.grupo16.techchallenge.eletrodomestico.usecase;

import lombok.extern.slf4j.Slf4j;
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

    @Autowired
    private ObterEletrodomesticoUseCase obterEletrodomesticoUseCase;


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

        var eletrodomesticoEncontrado = obterEletrodomesticoUseCase.obterPeloIdEEnderecoId(eletrodomestico.getId(), eletrodomestico.getEndereco().getId());

        Eletrodomestico eletrodomesticoToUpdate = Eletrodomestico.builder()
                .id(eletrodomesticoEncontrado.getId())
                .nome(eletrodomestico.getNome())
                .modelo(eletrodomestico.getModelo())
                .marca(eletrodomestico.getMarca())
                .cor(eletrodomestico.getCor())
                .potencia(eletrodomestico.getPotencia())
                .voltagem(eletrodomestico.getVoltagem())
                .endereco(eletrodomesticoEncontrado.getEndereco())
                .build();

        eletrodomesticoRepository.criar(eletrodomesticoToUpdate);

        log.trace("End");
    }
}
