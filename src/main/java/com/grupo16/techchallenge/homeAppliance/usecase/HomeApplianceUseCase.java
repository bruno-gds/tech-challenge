package com.grupo16.techchallenge.homeAppliance.usecase;

import com.grupo16.techchallenge.homeAppliance.domain.HomeAppliance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HomeApplianceUseCase {

    public Long create(HomeAppliance homeAppliance) {
        log.trace("Start homeAppliance={}", homeAppliance);


    }
}
