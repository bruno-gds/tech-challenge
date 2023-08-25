package com.grupo16.techchallenge.eletrodomestico.gateway;

import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface EletrodomesticoRepositoryGateway {

    public Long criar(Eletrodomestico eletrodomestico);

    public Optional<Eletrodomestico> obterIdEIdEndereco(Long id, Long idEndereco);

    public Optional<Eletrodomestico> obter(Long id);

    public Page<Eletrodomestico> obterTodos(PageRequest pageRequest);

    public Optional<List<Eletrodomestico>> buscaFiltrada(String nome, String modelo, String marca, Long potencia);

    public void remover(Long id);
}
