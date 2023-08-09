package com.grupo16.techchallenge.user.controller.json;

import com.grupo16.techchallenge.user.domain.RelatedUser;
import com.grupo16.techchallenge.user.domain.UserGender;

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
