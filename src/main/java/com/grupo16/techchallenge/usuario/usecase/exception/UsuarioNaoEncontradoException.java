package com.grupo16.techchallenge.usuario.usecase.exception;

import com.grupo16.techchallenge.common.exception.SystemBaseException;

import lombok.Getter;

@Getter
public class UsuarioNaoEncontradoException extends SystemBaseException {
	private static final long serialVersionUID = -1857427794848392323L;

	private final String code = "tc.usuario.usuarioNaoEncontrado";
	private final String message = "Usuario não encontrado.";
	private final Integer httpStatus = 404;
	
}
