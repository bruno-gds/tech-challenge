package com.grupo16.techchallenge.endereco.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.endereco.domain.Endereco;
import com.grupo16.techchallenge.endereco.gateway.EnderecoRepositoryGateway;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RemoverEnderecoUseCase {
	
	@Autowired
	private EnderecoRepositoryGateway enderecoRepository;
	
	@Autowired
	private ObterEnderecoUseCase obterEnderecoUseCase;

	public void remover(Long id, Long idUsuario) {
		log.trace("Start id={}", id);

		Endereco endereco = obterEnderecoUseCase.obterByIdAndUsuarioId(id,idUsuario);
		
		enderecoRepository.remover(endereco.getId());
		
		log.trace("End");
		
	}

}
