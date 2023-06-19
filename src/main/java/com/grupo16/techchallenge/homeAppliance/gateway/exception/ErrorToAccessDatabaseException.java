package com.grupo16.techchallenge.homeAppliance.gateway.exception;

import com.grupo16.techchallenge.common.exception.SystemBaseException;

import lombok.Getter;

@Getter
public class ErrorToAccessDatabaseException extends SystemBaseException{
	private static final long serialVersionUID = 3310150815407960688L;
	
	private final String code = "tc.homeAppliance.errorToAccessDatabase";
	private final String message = "Ocorreu um erro ao acessar o banco de dados.";
	private final Integer httpStatus = 500;

}
