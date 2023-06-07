package com.grupo16.techchallenge.address.controller;

import com.grupo16.techchallenge.address.controller.json.AddressJson;
import com.grupo16.techchallenge.address.domain.Address;
import com.grupo16.techchallenge.address.repository.AddressRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/enderecos")
@AllArgsConstructor
public class AddressController {

    private AddressRepository enderecoRepository;
    private Validator validator;

    @PostMapping
    public ResponseEntity createAddress(@RequestBody AddressJson enderecoJson) {
        Set<ConstraintViolation<AddressJson>> violacoes = validator.validate(enderecoJson);
        Map<Path, String> violacoesToMap = violacoes
                .stream()
                .collect(Collectors.toMap(ConstraintViolation::getPropertyPath, ConstraintViolation::getMessage));

        if (!violacoesToMap.isEmpty()) return ResponseEntity.badRequest().body(violacoesToMap);

        Address endereco = enderecoJson.toEndereco();
        enderecoRepository.save(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoJson);
    }
}
