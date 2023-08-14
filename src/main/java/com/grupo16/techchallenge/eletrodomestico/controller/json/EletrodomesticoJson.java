package com.grupo16.techchallenge.eletrodomestico.controller.json;

import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EletrodomesticoJson {

    @NotBlank
    private String name;

    @NotBlank
    private String model;

    @NotBlank
    private String brand;

    private String color;

    @NotNull
    private Long power;

    @NotNull
    private Long voltage;

    public Eletrodomestico toHomeAppliance() {
        return Eletrodomestico.builder()
                .build();
    }
}
