package com.grupo16.techchallenge.address.controller.json;

import com.grupo16.techchallenge.address.domain.Address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class AddressJson {

	@NotBlank(message = "Rua é um campo obrigatótio e não pode estar em branco")
    private String street;

	@NotBlank(message = "Numero é obrigatório e não pode estar em branco")
    private Long number;

	@NotBlank(message = "Bairro é um campo obrigatótio e não pode estar em branco")
    private String neighborhood;

	@NotBlank(message = "Cidade é um campo obrigatótio e não pode estar em branco")
    private String city;

	@NotNull(message = "Estado é obrigatório")
    @Size(min = 2, max = 2, message = "Estado deve ter 2 caracteres")
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
