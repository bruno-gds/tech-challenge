package com.grupo16.techchallenge.endereco.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.endereco.domain.Endereco;
import com.grupo16.techchallenge.endereco.gateway.EnderecoRepositoryGateway;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ObterEnderecoUseCase {
	
	@Autowired
	private EnderecoRepositoryGateway enderecoRepository;

	public List<Endereco> obterTodos(Long idUsuario) {
		log.trace("Start idUsuario={}", idUsuario);
		
		List<Endereco> enderecos = enderecoRepository.obterTodosByIdUsuario(idUsuario);
		
		log.trace("End enderecos={}", enderecos);
		return enderecos;
	}

}
