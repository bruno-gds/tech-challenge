package com.grupo16.techchallenge.endereco.gateway;

import java.util.List;
import java.util.Optional;

import com.grupo16.techchallenge.endereco.domain.Endereco;
import com.grupo16.techchallenge.endereco.dto.PesquisarEnderecoParamsDto;

public interface EnderecoRepositoryGateway {
	
	public Long salvar(Endereco endereco);

	public Optional<Endereco> obterByIdAndUsuarioId(Long id, Long idUsuario);

	public void remover(Long id);

	public List<Endereco> pesquisar(PesquisarEnderecoParamsDto paramsDto);

}
