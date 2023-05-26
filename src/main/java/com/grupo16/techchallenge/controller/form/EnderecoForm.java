package com.grupo16.techchallenge.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.grupo16.techchallenge.domain.Endereco;
import com.grupo16.techchallenge.domain.Estado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EnderecoForm {
    @JsonProperty
    @NotBlank(message = "Rua é um campo obrigatótio e não pode estar em branco")
    private String rua;
    @JsonProperty
    @NotNull(message = "Numero é obrigatório")
    private Integer numero;
    @JsonProperty
    @NotBlank(message = "Bairro é um campo obrigatótio e não pode estar em branco")
    private String bairro;
    @JsonProperty
    @NotBlank(message = "Cidade é um campo obrigatótio e não pode estar em branco")
    private String cidade;
    @JsonProperty
    @NotNull(message = "Estado é obrigatório")
    private Estado estado;

    public Endereco toEndereco() {
        return new Endereco(rua, numero, bairro, cidade, estado);
    }
}
