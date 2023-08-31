package com.grupo16.techchallenge.endereco.gateway.exception;

import com.grupo16.techchallenge.common.exception.SystemBaseException;

import lombok.Getter;

@Getter
public class ErroAoExcluirEnderecoException extends SystemBaseException{
	private static final long serialVersionUID = -1738985112058252461L;

	private final String code = "tc.endereco.erroAoExcluirEndereco";
	private final String message = "ATENÇÃO: Antes de excluir o endereço, por favor excluir os Eletrodomésticos associados à ele.";
	private final Integer httpStatus = 422;

}
