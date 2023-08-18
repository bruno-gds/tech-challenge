package com.grupo16.techchallenge.usuario.controller.json;

import com.grupo16.techchallenge.usuario.domain.Genero;
import com.grupo16.techchallenge.usuario.domain.Parente;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RelatedUserJson {
	
	private String name;
	private String parentage;
	private String gender;

	public Parente toRelatedUser() {
		return Parente.builder()
				.build();
	}
}
