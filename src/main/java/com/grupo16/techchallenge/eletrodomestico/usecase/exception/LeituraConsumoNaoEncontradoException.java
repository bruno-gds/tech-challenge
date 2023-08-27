package com.grupo16.techchallenge.eletrodomestico.usecase.exception;

import com.grupo16.techchallenge.common.exception.SystemBaseException;
import lombok.Getter;

@Getter
public class LeituraConsumoNaoEncontradoException extends SystemBaseException {
    private static final long serialVersionUID = -3765220527676217458L;
    
	private final String code = "tc.consumo.leituraConsumoNaoEncontrado";
    private final String message = "Leitura não encontrada.";
    private final Integer httpStatus = 404;
}
