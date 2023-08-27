package com.grupo16.techchallenge.endereco.dto;

import com.grupo16.techchallenge.endereco.domain.Estado;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PesquisarEnderecoParamsDto {
	private Long idUsuario;
	private String rua;
	private String bairro;
	private String cidade;
	private Estado estado;
	private String cep;
	
	public boolean hasRua() {
		return rua != null && !rua.isEmpty();
	}

	public boolean hasBairro() {
		return bairro != null && !bairro.isEmpty();
	}

	public boolean hasCidade() {
		return cidade != null && !cidade.isEmpty();
	}

	public boolean hasEstado() {
		return estado != null;
	}

	public boolean hasCep() {
		return cep != null && !cep.isEmpty();
	}
	
}
