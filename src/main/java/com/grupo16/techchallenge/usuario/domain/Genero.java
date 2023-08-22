package com.grupo16.techchallenge.usuario.domain;

import lombok.Getter;

@Getter
public enum Genero {

	MASCULINO(0),
	FEMININO(1);
	
	private int value;
	
	Genero(int value) {
		this.value = value;
	}
	
	public static Genero getByOrdinal(int ordinal) {
		Genero[] values = values();
		return values[ordinal];
 	}
	
}
