package com.grupo16.techchallenge.endereco.dto;

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
	private String estado;
	private String cep;
	
	public boolean hasRua() {
		return rua != null && !rua.isEmpty();
	}
	
}
