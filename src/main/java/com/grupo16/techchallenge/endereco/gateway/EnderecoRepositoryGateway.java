package com.grupo16.techchallenge.endereco.gateway;

import java.util.List;

import com.grupo16.techchallenge.endereco.domain.Endereco;

public interface EnderecoRepositoryGateway {
	
	public Long criar(Endereco endereco);

	public List<Endereco> obterTodosByIdUsuario(Long idUsuario);

}
