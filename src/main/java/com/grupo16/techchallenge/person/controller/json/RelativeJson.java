package com.grupo16.techchallenge.person.controller.json;

import com.grupo16.techchallenge.person.domain.Relative;

import lombok.Getter;

@Getter
public class RelativeJson {
	
	private String name;
	private String parentage;
	private String gender;

	public Relative toRelative() {
		return Relative.builder()
				.name(name)
				.parentage(parentage)
				.gender(gender)
				.build();
	}
}
