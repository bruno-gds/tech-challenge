package com.grupo16.techchallenge.usuario.usecase.exception;

import com.grupo16.techchallenge.common.exception.SystemBaseException;

import lombok.Getter;

@Getter
public class CpfJaCadastradoException extends SystemBaseException {
	private static final long serialVersionUID = 4012200300232962702L;

	private final String code = "tc.usuario.CpfJaCadastrado";
	private final String message = "CPF já cadastrado.";
	private final Integer httpStatus = 422;
	
}
