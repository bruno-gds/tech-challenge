package com.grupo16.techchallenge.user.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Parentesco {
	
	private Long id;
	private Usuario usuario;
	private Usuario usuarioParente;
	private String tipoParentesco;
	
}
