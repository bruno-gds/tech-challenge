package com.grupo16.techchallenge.person.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class RelatedUser {
	
	private String name;
	private String parentage;
	private String gender;	
}
