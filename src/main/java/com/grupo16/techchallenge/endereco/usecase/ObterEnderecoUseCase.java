package com.grupo16.techchallenge.endereco.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.endereco.domain.Endereco;
import com.grupo16.techchallenge.endereco.dto.PesquisarEnderecoParamsDto;
import com.grupo16.techchallenge.endereco.gateway.EnderecoRepositoryGateway;
import com.grupo16.techchallenge.endereco.usecase.exception.EnderecoNaoEcontradoException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ObterEnderecoUseCase {
	
	@Autowired
	private EnderecoRepositoryGateway enderecoRepositoryGateway;

	public Endereco obterByIdAndUsuarioId(Long id, Long idUsuario) {
		log.trace("Start idEndereco={}, idUsuario={}", id, idUsuario);
		
		Optional<Endereco> enderecoOp = enderecoRepositoryGateway.obterByIdAndUsuarioId(id, idUsuario);
		checarSeEnderecoFoiEncontrado(enderecoOp);
	
		log.trace("End endereco={}", enderecoOp.get());
		return enderecoOp.get();
	}
	
//	public Endereco obter(Long id) {
//		log.trace("Start id={}", id);
//		
//		Optional<Endereco> enderecoOp = enderecoRepositoryGateway.obter(id);
//		checarSeEnderecoFoiEncontrado(enderecoOp);
//		
//		log.trace("End endereco={}", enderecoOp.get());
//		return enderecoOp.get();
//	}
	
	public List<Endereco> pesquisar(PesquisarEnderecoParamsDto paramsDto) {
		log.trace("Start paramsDto={}", paramsDto);
		
		List<Endereco> enderecos = enderecoRepositoryGateway.pesquisar(paramsDto);
		
		log.trace("End enderecos={}", enderecos);
		return enderecos;
	}

	private void checarSeEnderecoFoiEncontrado(Optional<Endereco> enderecoOp) {
		if(enderecoOp.isEmpty()) {
			log.warn("Endereco não encontrado.");
			throw new EnderecoNaoEcontradoException();
		}
	}
}
