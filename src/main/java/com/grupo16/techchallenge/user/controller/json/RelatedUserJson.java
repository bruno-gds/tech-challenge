package com.grupo16.techchallenge.user.controller.json;

import com.grupo16.techchallenge.user.domain.Parentesco;
import com.grupo16.techchallenge.user.domain.Genero;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RelatedUserJson {
	
	private String name;
	private String parentage;
	private String gender;

	public Parentesco toRelatedUser() {
		return Parentesco.builder()
				.build();
	}
}
