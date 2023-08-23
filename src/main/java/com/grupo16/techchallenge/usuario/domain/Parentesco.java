package com.grupo16.techchallenge.usuario.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Parentesco {
	
	private Usuario usuario;
	private Usuario usuarioParente;
	private TipoParentesco tipoParentesco;
	
}
