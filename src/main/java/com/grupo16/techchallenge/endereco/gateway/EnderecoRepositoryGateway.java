package com.grupo16.techchallenge.endereco.gateway;

import java.util.List;
import java.util.Optional;

import com.grupo16.techchallenge.endereco.domain.Endereco;

public interface EnderecoRepositoryGateway {
	
	public Long salvar(Endereco endereco);

	public List<Endereco> obterTodosByUsuarioId(Long idUsuario);

	public Optional<Endereco> obterByIdAndUsuarioId(Long id, Long idUsuario);

	public Optional<Endereco> obter(Long id);

}
