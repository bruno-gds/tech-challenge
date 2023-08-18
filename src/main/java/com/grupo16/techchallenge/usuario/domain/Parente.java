package com.grupo16.techchallenge.usuario.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Parente {
	
	private Long id;
	private Usuario usuario;
	private Usuario usuarioParente;
	private String tipoParentesco;
	
}
