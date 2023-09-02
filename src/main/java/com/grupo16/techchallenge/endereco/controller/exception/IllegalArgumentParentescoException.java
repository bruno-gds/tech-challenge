package com.grupo16.techchallenge.endereco.controller.exception;

import com.grupo16.techchallenge.common.exception.SystemBaseException;
import lombok.Getter;

@Getter
public class IllegalArgumentParentescoException extends SystemBaseException {
    private static final long serialVersionUID = 6596480903370069639L;
    
	private final String code = "tc.usuario.IllegalArgumentParentesco";
    private final String message = "O campo parentesco deve ser preenchido.";
    private final Integer httpStatus = 422;
}
