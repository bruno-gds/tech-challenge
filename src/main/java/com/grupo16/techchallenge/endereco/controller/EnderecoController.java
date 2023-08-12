package com.grupo16.techchallenge.endereco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.techchallenge.endereco.controller.json.EnderecoJson;
import com.grupo16.techchallenge.endereco.domain.Endereco;
import com.grupo16.techchallenge.endereco.usecase.CriarAlterarEnderecoUseCase;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
	
	@Autowired	
    private CriarAlterarEnderecoUseCase criarAlterarEnderecoUseCase;

	@ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Long criar(@Valid @RequestBody EnderecoJson enderecoJson) {
    	log.trace("Start enderecoJson={}", enderecoJson);

    	Endereco endereco = enderecoJson.mapToEnderecoDomain();
        Long id = criarAlterarEnderecoUseCase.criar(endereco);
        
        log.trace("End id={}", id);
        return id;
    }
}
