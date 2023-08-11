package com.grupo16.techchallenge.eletrodomestico.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.grupo16.techchallenge.eletrodomestico.controller.json.HomeApplianceJson;
import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;
import com.grupo16.techchallenge.eletrodomestico.usecase.HomeApplianceUseCase;

@Slf4j
@RestController
@RequestMapping("/homeAppliances")
public class HomeApplianceController {

    @Autowired
    private HomeApplianceUseCase homeApplianceUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Long create(@Valid @RequestBody HomeApplianceJson homeApplianceJson) {
        log.trace("Start homeApplianceJson={}", homeApplianceJson);

        Eletrodomestico homeAppliance = homeApplianceJson.toHomeAppliance();

        Long homeApplianceId = homeApplianceUseCase.create(homeAppliance);

        log.trace("End homeApplianceId={}", homeApplianceId);
        return homeApplianceId;
    }
}
