package com.grupo16.techchallenge.address.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Address {

	private String street;
	private Long number;
	private String neighborhood;
	private String city;
	private String state;
}
