package com.grupo16.techchallenge.eletrodomestico.gateway.exception;

import com.grupo16.techchallenge.common.exception.SystemBaseException;

import lombok.Getter;

@Getter
public class ErroAoExcluirEletrodomesticoException extends SystemBaseException{
	private static final long serialVersionUID = -1738985112058252461L;

	private final String code = "tc.eletrodomestico.erroAoExcluirEletrodomestico";
	private final String message = "ATENÇÃO: Antes de excluir o eletrodoméstico, por favor excluir suas Leituras de Consumo.";
	private final Integer httpStatus = 422;

}
