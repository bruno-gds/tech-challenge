package com.grupo16.techchallenge.address.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Address {

	private String street;
	private Long number;
	private String neighborhood;
	private String city;
	private String state;
}
