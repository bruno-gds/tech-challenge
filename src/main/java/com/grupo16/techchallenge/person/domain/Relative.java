package com.grupo16.techchallenge.person.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Relative {
	
	private String name;
	private String parentage;
	private String gender;	
}
