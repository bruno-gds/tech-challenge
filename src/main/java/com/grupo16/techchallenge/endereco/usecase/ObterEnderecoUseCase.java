package com.grupo16.techchallenge.endereco.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.endereco.domain.Endereco;
import com.grupo16.techchallenge.endereco.gateway.EnderecoRepositoryGateway;
import com.grupo16.techchallenge.endereco.usecase.exception.EnderecoNaoEcontradoException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ObterEnderecoUseCase {
	
	@Autowired
	private EnderecoRepositoryGateway enderecoRepository;

	public List<Endereco> obterTodosByIdUsuario(Long idUsuario) {
		log.trace("Start idUsuario={}", idUsuario);
		
		List<Endereco> enderecos = enderecoRepository.obterTodosByUsuarioId(idUsuario);
		
		log.trace("End enderecos={}", enderecos);
		return enderecos;
	}

	public Endereco obterByIdAndUsuarioId(Long id, Long idUsuario) {
		log.trace("Start idEndereco={}, idUsuario={}", id, idUsuario);
		Optional<Endereco> enderecoOp = enderecoRepository.obterByIdAndUsuarioId(id, idUsuario);
		
		if(enderecoOp.isEmpty()) {
			log.warn("Endereco não encontrado.");
			throw new EnderecoNaoEcontradoException();
		}
	
		log.trace("End endereco={}", enderecoOp.get());
		return enderecoOp.get();
	}
	
	public Endereco obter(Long id) {
		log.trace("Start id={}", id);
		
		Optional<Endereco> enderecoOp = enderecoRepository.obter(id);
		
		log.trace("End endereco={}");
		return null;
	}

}
