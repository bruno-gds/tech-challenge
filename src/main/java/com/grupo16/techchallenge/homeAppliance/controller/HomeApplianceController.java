package com.grupo16.techchallenge.homeAppliance.controller;

import com.grupo16.techchallenge.homeAppliance.controller.json.HomeApplianceJson;
import com.grupo16.techchallenge.homeAppliance.domain.HomeAppliance;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/homeAppliance")
public class HomeApplianceController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Long create(@Valid @RequestBody HomeApplianceJson homeApplianceJson) {
        log.trace("Start homeApplianceJson={}", homeApplianceJson);

        HomeAppliance homeAppliance = homeApplianceJson.toHomeAppliance();

    }
}
