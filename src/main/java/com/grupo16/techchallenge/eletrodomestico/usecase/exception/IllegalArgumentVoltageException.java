package com.grupo16.techchallenge.eletrodomestico.usecase.exception;

import com.grupo16.techchallenge.common.exception.SystemBaseException;
import lombok.Getter;

@Getter
public class IllegalArgumentVoltageException extends SystemBaseException {
    private static final long serialVersionUID = 4012200300232962702L;

    private final String code = "tc.eletrodomestico.IllegalArgumentVoltage";
    private final String message = "Voltagem inválida, aceito apenas '110' e '220'.";
    private final Integer httpStatus = 422;
}
