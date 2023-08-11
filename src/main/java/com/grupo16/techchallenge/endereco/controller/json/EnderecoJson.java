package com.grupo16.techchallenge.endereco.controller.json;

import com.grupo16.techchallenge.endereco.domain.Endereco;
import com.grupo16.techchallenge.endereco.domain.State;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EnderecoJson {

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

    public Endereco toEndereco() {
        return Endereco.builder()
        		
        		.build();
    }
}
