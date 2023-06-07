package com.grupo16.techchallenge.address.repository;

import com.grupo16.techchallenge.address.domain.Address;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class AddressRepository {

    private Set<Address> enderecos;

    public AddressRepository() {
        enderecos = new HashSet<>();
    }

    public void save(Address endereco) {
        enderecos.add(endereco);
    }
}
