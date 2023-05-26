package com.grupo16.techchallenge.repository;

import com.grupo16.techchallenge.domain.Endereco;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class EnderecoRepository {

    private Set<Endereco> enderecos;

    public EnderecoRepository() {
        enderecos = new HashSet<>();
    }

    public void save(Endereco endereco) {
        enderecos.add(endereco);
    }
}
