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
import jakarta.validation.Validator;

@RestController
@RequestMapping("/adresses")
public class AddressController {
	
	@Autowired	
    private AddressUseCase addressUseCase;

	@Autowired	
    private Validator validator;

    @PostMapping
    public Long create(@Valid @RequestBody AddressJson addressJson) {
//        Set<ConstraintViolation<AddressJson>> violacoes = validator.validate(addressJson);
//        Map<Path, String> violacoesToMap = violacoes
//                .stream()
//                .collect(Collectors.toMap(ConstraintViolation::getPropertyPath, ConstraintViolation::getMessage));
//
//        if (!violacoesToMap.isEmpty()) return ResponseEntity.badRequest().body(violacoesToMap);

        Address address = addressJson.toAddress();
        
        
        
        Long addressId = addressUseCase.create(address);
//        return ResponseEntity.status(HttpStatus.CREATED).body(addressJson);
        return null;
    }
}
