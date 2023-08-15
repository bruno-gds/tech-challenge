package com.grupo16.techchallenge.endereco.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.endereco.domain.Endereco;
import com.grupo16.techchallenge.endereco.gateway.EnderecoRepositoryGateway;
import com.grupo16.techchallenge.endereco.usecase.exception.EnderecoNaoEcontradoException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CriarAlterarEnderecoUseCase {

	@Autowired
	private EnderecoRepositoryGateway enderecoRepository;
	
	public Long criar(Endereco endereco) {
		log.trace("Start endereco={}", endereco);
		
		Long id = enderecoRepository.criar(endereco);
		
		log.trace("End id={}", id);
		return id;
	}

	public void alterar(Endereco endereco) {
		log.trace("Start endereco={}", endereco);
		
		Optional<Endereco> enderecoOp = enderecoRepository.obterByIdAndIdUsuario(endereco.getId(), endereco.getUsuario().getId());
		
		if(enderecoOp.isEmpty()) {
			throw new EnderecoNaoEcontradoException();
		}
		
		log.trace("End");
	}
}
