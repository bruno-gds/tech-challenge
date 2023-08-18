package com.grupo16.techchallenge.eletrodomestico.usecase.exception;

import com.grupo16.techchallenge.common.exception.SystemBaseException;

import lombok.Getter;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 17/08/2023
 * Project Name: tech-challenge
 */

@Getter
public class EletrodomesticoNaoEncontradoException extends SystemBaseException {
    // TODO: perguntar para Tati
    private static final long serialVersionUID = 3764568709707489646L;

    private final String code = "tc.eletrodomestico.eletrodomesticoNaoEcontrado";
    private final String message = "Eletrodomestico não encontrado.";
    private final Integer httpStatus = 422;
}
