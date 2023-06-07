package com.grupo16.techchallenge.address.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.grupo16.techchallenge.address.domain.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EnderecoJson {
    @JsonProperty
    @NotBlank(message = "Rua é um campo obrigatótio e não pode estar em branco")
    private String rua;
    @JsonProperty
    @NotBlank(message = "Numero é obrigatório e não pode estar em branco")
    private String numero;
    @JsonProperty
    @NotBlank(message = "Bairro é um campo obrigatótio e não pode estar em branco")
    private String bairro;
    @JsonProperty
    @NotBlank(message = "Cidade é um campo obrigatótio e não pode estar em branco")
    private String cidade;
    @JsonProperty
    @NotNull(message = "Estado é obrigatório")
    @Size(min = 2, max = 2, message = "Estado deve ter 2 caracteres")
    private String estado;

    public Endereco toEndereco() {
        return new Endereco(rua, numero, bairro, cidade, estado);
    }
}
