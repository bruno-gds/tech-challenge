package com.grupo16.techchallenge.address.gateway.repository;

import com.grupo16.techchallenge.address.domain.Address;
import com.grupo16.techchallenge.address.gateway.AddressRepositoryGateway;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Repository
public class AddressLocalRepositoryGateway implements AddressRepositoryGateway {
	private Long sequenceId = 1L;
	
    private Set<Address> adresses;

    public AddressLocalRepositoryGateway() {
        adresses = new HashSet<>();
    }

	@Override
	public Long create(Address address) {
		log.trace("Start address={}", address);
		address.setId(sequenceId++);
		
		adresses.add(address);		
		Long addressId = address.getId();
		
		log.trace("End addressId={}", addressId);
		return addressId;
	}
}
