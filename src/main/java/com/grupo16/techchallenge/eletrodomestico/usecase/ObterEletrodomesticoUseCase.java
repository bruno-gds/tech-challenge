package com.grupo16.techchallenge.eletrodomestico.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;
import com.grupo16.techchallenge.eletrodomestico.gateway.EletrodomesticoRepositoryGateway;
import com.grupo16.techchallenge.eletrodomestico.usecase.exception.EletrodomesticoNaoEncontradoException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ObterEletrodomesticoUseCase {

    @Autowired
    private EletrodomesticoRepositoryGateway eletrodomesticoRepository;

    public Eletrodomestico obterPeloIdAndUsuarioId(Long id, Long idUsuario) {
        log.trace("Start idEletodomestico={}, idEndereco={}", id, idUsuario);

        Optional<Eletrodomestico> eletrodomesticoOp = eletrodomesticoRepository.obterIdAndUsuarioId(id, idUsuario);
        checarSeEletrodomesticoFoiEncontrado(eletrodomesticoOp);

        log.trace("End eletrodomestico={}", eletrodomesticoOp.get());
        return eletrodomesticoOp.get();
    }

    public Eletrodomestico obter(Long id) {
        log.trace("Start id={}", id);

        Optional<Eletrodomestico> eletrodomesticoOp = eletrodomesticoRepository.obter(id);
        checarSeEletrodomesticoFoiEncontrado(eletrodomesticoOp);

        log.trace("End eletrodomestico={}", eletrodomesticoOp.get());

        return eletrodomesticoOp.get();
    }

    public List<Eletrodomestico> buscaFiltrada(Long idUsuario, String nome, String modelo, String marca, Long potencia) {
        log.trace("Start idUsuario={}, nome={}, modelo={}, marca={}, potencia={}", idUsuario, nome, modelo, marca, potencia);

        var eletrodomestico = eletrodomesticoRepository.buscaFiltrada(idUsuario, nome, modelo, marca, potencia);

        log.trace("End eletrodomestico={}", eletrodomestico);

        return eletrodomestico;
    }

    private void checarSeEletrodomesticoFoiEncontrado(Optional<Eletrodomestico> eletrodomesticoOp) {
        if(eletrodomesticoOp.isEmpty()) {
            log.warn("Eletrodomestico não encontrado.");
            throw new EletrodomesticoNaoEncontradoException();
        }
    }

}
