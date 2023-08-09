package com.grupo16.techchallenge.address.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Address {

	@Setter
	private Long id;
	private String street;
	private String number;
	private String neighborhood;
	private String city;
	private State state;
}
