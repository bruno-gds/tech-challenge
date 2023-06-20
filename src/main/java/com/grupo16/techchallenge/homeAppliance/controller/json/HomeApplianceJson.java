package com.grupo16.techchallenge.homeAppliance.controller.json;

import com.grupo16.techchallenge.homeAppliance.domain.HomeAppliance;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class HomeApplianceJson {

    @NotBlank
    private String name;

    @NotBlank
    private String model;

    @NotBlank
    private String brand;

    @NotBlank
    private String color;

    @NotNull
    private Long power;

    @NotNull
    private Long voltage;

    public HomeAppliance toHomeAppliance() {
        return HomeAppliance.builder()
                .name(name)
                .model(model)
                .color(color)
                .power(power)
                .voltage(voltage)
                .build();
    }
}
