package com.grupo16.techchallenge.address.controller;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.techchallenge.address.controller.json.AddressJson;
import com.grupo16.techchallenge.address.domain.Address;
import com.grupo16.techchallenge.address.repository.AddressRepository;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.Validator;

@RestController
@RequestMapping("/adresses")
public class AddressController {
	
	@Autowired	
    private AddressRepository addressRepository;

	@Autowired	
    private Validator validator;

    @PostMapping
    public ResponseEntity create(@RequestBody AddressJson addressJson) {
        Set<ConstraintViolation<AddressJson>> violacoes = validator.validate(addressJson);
        Map<Path, String> violacoesToMap = violacoes
                .stream()
                .collect(Collectors.toMap(ConstraintViolation::getPropertyPath, ConstraintViolation::getMessage));

        if (!violacoesToMap.isEmpty()) return ResponseEntity.badRequest().body(violacoesToMap);

        Address address = addressJson.toAddress();
        addressRepository.save(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(addressJson);
    }
}
