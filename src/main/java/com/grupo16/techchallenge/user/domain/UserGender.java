package com.grupo16.techchallenge.user.domain;

import lombok.Getter;

@Getter
public enum UserGender {

	MASCULINO(1),
	FEMININO(2);
	
	private int value;
	
	UserGender(int value) {
		this.value = value;
	}
	
}
