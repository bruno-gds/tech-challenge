package com.grupo16.techchallenge.homeAppliance.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class HomeAppliance {

    @Setter
    private Long id;
    private String name;
    private String model;
    private String brand;
    private String color;
    private Long power;
    private Long voltage;
}
