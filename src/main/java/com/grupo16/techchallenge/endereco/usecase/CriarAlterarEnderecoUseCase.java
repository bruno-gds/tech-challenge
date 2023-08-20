package com.grupo16.techchallenge.endereco.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.endereco.domain.Endereco;
import com.grupo16.techchallenge.endereco.gateway.EnderecoRepositoryGateway;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CriarAlterarEnderecoUseCase {

	@Autowired
	private EnderecoRepositoryGateway enderecoRepository;
	
	@Autowired
	private ObterEnderecoUseCase obterEnderecoUseCase;
	
	public Long criar(Endereco endereco) {
		log.trace("Start endereco={}", endereco);
		
		/*
		 *TODO: conferir se o id usuario existe
		 *Para isso, criar um gateway e implementar a chamada para o 
		 *microsservico Usuario;  
		 */
		
		Long id = enderecoRepository.salvar(endereco);
		
		log.trace("End id={}", id);
		return id;
	}

	public void alterar(Endereco endereco) {
		log.trace("Start endereco={}", endereco);
		
		Endereco enderecoEncontrado = obterEnderecoUseCase.obterByIdAndUsuarioId(endereco.getId(), endereco.getUsuario().getId());
		
		Endereco enderecoToUpdate = Endereco.builder()
				.id(enderecoEncontrado.getId())
				.rua(endereco.getRua())
				.numero(endereco.getNumero())
				.bairro(endereco.getBairro())
				.cidade(endereco.getCidade())
				.estado(endereco.getEstado())
				.cep(endereco.getCep())
				.usuario(enderecoEncontrado.getUsuario())
				.build();
		
		enderecoRepository.salvar(enderecoToUpdate);
		
		log.trace("End");
	}
}
