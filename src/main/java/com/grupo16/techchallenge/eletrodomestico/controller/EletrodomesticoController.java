package com.grupo16.techchallenge.eletrodomestico.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.grupo16.techchallenge.eletrodomestico.controller.json.EletrodomesticoJson;
import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;
import com.grupo16.techchallenge.eletrodomestico.usecase.EletrodomesticoUseCase;

@Slf4j
@RestController
@RequestMapping("/homeAppliances")
public class EletrodomesticoController {

    @Autowired
    private EletrodomesticoUseCase eletrodomesticoUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Long create(@Valid @RequestBody EletrodomesticoJson eletrodomesticoJson) {
        log.trace("Start homeApplianceJson={}", eletrodomesticoJson);

        Eletrodomestico homeAppliance = eletrodomesticoJson.toHomeAppliance();

        Long homeApplianceId = eletrodomesticoUseCase.create(homeAppliance);

        log.trace("End homeApplianceId={}", homeApplianceId);
        return homeApplianceId;
    }
}
