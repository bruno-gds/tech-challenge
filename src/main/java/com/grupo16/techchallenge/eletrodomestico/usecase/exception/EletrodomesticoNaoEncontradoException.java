package com.grupo16.techchallenge.eletrodomestico.usecase.exception;

import com.grupo16.techchallenge.common.exception.SystemBaseException;

import lombok.Getter;

@Getter
public class EletrodomesticoNaoEncontradoException extends SystemBaseException {
    private static final long serialVersionUID = -4775973697372629912L;

    private final String code = "tc.eletrodomestico.eletrodomesticoNaoEcontrado";
    private final String message = "Eletrodomestico não encontrado.";
    private final Integer httpStatus = 422;
}
