package com.grupo16.techchallenge.user.gateway.exception;

import com.grupo16.techchallenge.common.exception.SystemBaseException;

import lombok.Getter;

@Getter
public class ErrorToAccessDatabaseException extends SystemBaseException{
	private static final long serialVersionUID = -1738985112058252461L;

	private final String code = "tc.person.errorToAccessDatabase";
	private final String message = "Ocorreu um erro ao acessar o banco de dados.";
	private final Integer httpStatus = 500;

}
