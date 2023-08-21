package com.grupo16.techchallenge.eletrodomestico.gateway;

import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;

import java.util.Optional;

public interface EletrodomesticoRepositoryGateway {

    public Long criar(Eletrodomestico eletrodomestico);

    public Optional<Eletrodomestico> obterIdEIdEndereco(Long id, Long idEndereco);

    public Optional<Eletrodomestico> obter(Long id);

    public void remover(Long id);
}
