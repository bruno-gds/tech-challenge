package com.grupo16.techchallenge.address.controller.json;

import com.grupo16.techchallenge.address.domain.Address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AddressJson {

	@NotBlank
    private String street;

	@NotBlank
    private String number;

	@NotBlank
    private String neighborhood;

	@NotBlank
    private String city;

	@NotNull
	@Pattern(regexp = "^[A-Z]{2}$", message = "O estado deve estar no formato 'SP'")
    private String state;

    public Address toAddress() {
        return Address.builder()
        		.street(street)
				.number(number)
				.neighborhood(neighborhood)
				.city(city)
				.state(state)
        		.build();
    }
}
