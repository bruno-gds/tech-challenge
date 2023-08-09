package com.grupo16.techchallenge.person.controller.json;

import com.grupo16.techchallenge.person.domain.RelatedUser;
import com.grupo16.techchallenge.person.domain.UserGender;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RelatedUserJson {
	
	private String name;
	private String parentage;
	private String gender;

	public RelatedUser toRelatedUser() {
		return RelatedUser.builder()
				.name(name)
				.parentage(parentage)
				.gender(UserGender.valueOf(gender))
				.build();
	}
}
