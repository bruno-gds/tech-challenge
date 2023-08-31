package com.grupo16.techchallenge.usuario.gateway.exception;

import com.grupo16.techchallenge.common.exception.SystemBaseException;

import lombok.Getter;

@Getter
public class ErroAoExcluirUsuarioException extends SystemBaseException{
	private static final long serialVersionUID = -1738985112058252461L;

	private final String code = "tc.usuario.erroAoExcluirUsuario";
	private final String message = "ATENÇÃO: Antes de excluir o usuário, por favor excluir os Endereços e Parentes associados à ele.";
	private final Integer httpStatus = 422;

}
