package com.grupo16.techchallenge.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.techchallenge.address.controller.json.AddressJson;
import com.grupo16.techchallenge.address.domain.Address;
import com.grupo16.techchallenge.address.usecase.AddressUseCase;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/adresses")
public class AddressController {
	
	@Autowired	
    private AddressUseCase addressUseCase;

    @PostMapping
    public Long create(@Valid @RequestBody AddressJson addressJson) {
    	log.trace("Start addressJson={}", addressJson);

    	Address address = addressJson.toAddress();
        Long addressId = addressUseCase.create(address);
        
        log.trace("End addressId={}", addressId);
        return addressId;
    }
}
