package com.grupo16.techchallenge.controller;

import com.grupo16.techchallenge.controller.form.EnderecoForm;
import com.grupo16.techchallenge.domain.Endereco;
import com.grupo16.techchallenge.repository.EnderecoRepository;
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
public class EnderecoController {

    private EnderecoRepository enderecoRepository;
    private Validator validator;

    @PostMapping
    public ResponseEntity createAddress(@RequestBody EnderecoForm enderecoForm) {
        Set<ConstraintViolation<EnderecoForm>> violacoes = validator.validate(enderecoForm);
        Map<Path, String> violacoesToMap = violacoes
                .stream()
                .collect(Collectors.toMap(ConstraintViolation::getPropertyPath, ConstraintViolation::getMessage));

        if (!violacoesToMap.isEmpty()) return ResponseEntity.badRequest().body(violacoesToMap);

        Endereco endereco = enderecoForm.toEndereco();
        enderecoRepository.save(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
    }
}
