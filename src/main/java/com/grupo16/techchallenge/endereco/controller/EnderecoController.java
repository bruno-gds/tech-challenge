package com.grupo16.techchallenge.endereco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.techchallenge.endereco.controller.json.EnderecoJson;
import com.grupo16.techchallenge.endereco.domain.Endereco;
import com.grupo16.techchallenge.endereco.usecase.ObterEnderecoUseCase;
import com.grupo16.techchallenge.endereco.usecase.CriarAlterarEnderecoUseCase;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
	
	@Autowired	
    private CriarAlterarEnderecoUseCase criarAlterarEnderecoUseCase;

	@Autowired	
	private ObterEnderecoUseCase obterEnderecoUseCase;

	@ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Long criar(@Valid @RequestBody EnderecoJson enderecoJson) {
    	log.trace("Start enderecoJson={}", enderecoJson);

    	Endereco endereco = enderecoJson.mapToEnderecoDomain();
        Long id = criarAlterarEnderecoUseCase.criar(endereco);
        
        log.trace("End id={}", id);
        return id;
    }
	
	@GetMapping
	public EnderecoJson obterPorIdUsuario(
			@RequestParam(name = "idUsuario") Long idUsuario) {
		log.trace("Start idUsuario={}", idUsuario);
		
		Endereco endereco = obterEnderecoUseCase.obterPorIdUsuario(idUsuario);
		
		EnderecoJson enderecoJson = new EnderecoJson(endereco);
		
		log.trace("End endereço={}", enderecoJson);
		return enderecoJson;
		
	}
	
	@GetMapping
	public List<EnderecoJson> obterTodos(
			@RequestParam(name = "idUsuario") Long idUsuario) {
		log.trace("Start idUsuario={}", idUsuario);
		
		List<Endereco> enderecos = obterEnderecoUseCase.obterTodosPorIdUsuario(idUsuario);
		
		List<EnderecoJson> enderecosJson = enderecos.stream().map(EnderecoJson::new).toList();
		
		log.trace("End enderecosJson={}", enderecosJson);
		return enderecosJson;
		
	}
	
	@PatchMapping
	public void update(
			@RequestBody(required = true) EnderecoJson enderecoJson) {
		log.trace("Start enderecoJson={}", enderecoJson);
		
		log.trace("End");
	}
}
