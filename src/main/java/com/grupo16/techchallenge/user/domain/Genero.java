package com.grupo16.techchallenge.user.domain;

import lombok.Getter;

@Getter
public enum Genero {

	MASCULINO(1),
	FEMININO(2);
	
	private int value;
	
	Genero(int value) {
		this.value = value;
	}
	
}