package com.grupo16.techchallenge.address.repository;

import com.grupo16.techchallenge.address.domain.Address;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class AddressRepository {

    private Set<Address> adresses;

    public AddressRepository() {
        adresses = new HashSet<>();
    }

    public void save(Address address) {
        adresses.add(address);
    }
}
