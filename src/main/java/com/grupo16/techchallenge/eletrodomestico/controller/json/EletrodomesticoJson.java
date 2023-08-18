package com.grupo16.techchallenge.eletrodomestico.controller.json;

import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;

import com.grupo16.techchallenge.endereco.controller.json.EnderecoJson;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EletrodomesticoJson {

    @NotBlank
    private String nome;

    @NotBlank
    private String modelo;

    @NotBlank
    private String marca;

    private String cor;

    @NotNull
    private Long potencia;

    @NotNull
    private Long voltagem;

    private EnderecoJson endereco;

    // TODO: BRUNO = Implementar medicoes consumo


    public Eletrodomestico mapeandoParaEletrodomestico() {

        return Eletrodomestico.builder()
                .nome(nome)
                .modelo(modelo)
                .marca(marca)
                .cor(cor)
                .potencia(potencia)
                .voltagem(voltagem)
                .build();
    }
}
