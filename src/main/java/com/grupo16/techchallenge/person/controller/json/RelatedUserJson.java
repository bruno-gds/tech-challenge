package com.grupo16.techchallenge.person.controller.json;

import com.grupo16.techchallenge.person.domain.RelatedUser;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RelatedUserJson {
	
	private String name;
	private String parentage;
	private String gender;

	public RelatedUser toRelative() {
		return RelatedUser.builder()
				.name(name)
				.parentage(parentage)
				.gender(gender)
				.build();
	}
}
