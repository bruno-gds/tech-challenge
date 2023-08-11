package com.grupo16.techchallenge.endereco.gateway.repository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Repository;

import com.grupo16.techchallenge.endereco.domain.Endereco;
import com.grupo16.techchallenge.endereco.gateway.AddressRepositoryGateway;
import com.grupo16.techchallenge.endereco.gateway.exception.ErrorToAccessDatabaseException;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Repository
public class AddressLocalRepositoryGateway implements AddressRepositoryGateway {
	private Long sequenceId = 1L;
	
    private Set<Endereco> adresses;

    public AddressLocalRepositoryGateway() {
        adresses = new HashSet<>();
    }

	@Override
	public Long create(Endereco address) {		
		try {
			log.trace("Start address={}", address);
			address.setId(sequenceId++);
			
			adresses.add(address);		
			Long addressId = address.getId();
			
			log.trace("End addressId={}", addressId);
			return addressId;
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErrorToAccessDatabaseException();
		}
	}
}
