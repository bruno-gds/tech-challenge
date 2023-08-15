package com.grupo16.techchallenge.endereco.usecase.exception;

import com.grupo16.techchallenge.common.exception.SystemBaseException;

import lombok.Getter;

@Getter
public class EnderecoNaoEcontradoException extends SystemBaseException{
	private static final long serialVersionUID = 3764568709707489646L;
	
	private final String code = "tc.endereco.enderecoNaoEcontrado";
	private final String message = "Endereço não encontrado.";
	private final Integer httpStatus = 422;

}
