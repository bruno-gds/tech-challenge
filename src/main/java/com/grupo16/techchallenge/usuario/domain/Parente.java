package com.grupo16.techchallenge.usuario.domain;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Parente extends Usuario {
	private Usuario usuarioPrinpal;
	private TipoParentesco parentesco;

}
