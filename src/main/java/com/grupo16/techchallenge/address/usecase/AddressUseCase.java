package com.grupo16.techchallenge.address.usecase;

import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.address.domain.Address;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressUseCase {

	
	public Long create(Address address) {
		log.trace("Start address={}", address);
		
		
//		log.trace("End addressId={}", addressId);
		return null;
	}
}
