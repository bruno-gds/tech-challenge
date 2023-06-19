package com.grupo16.techchallenge.homeAppliance.usecase;

import com.grupo16.techchallenge.homeAppliance.domain.HomeAppliance;
import com.grupo16.techchallenge.homeAppliance.gateway.HomeApplianceRepositoryGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HomeApplianceUseCase {

    @Autowired
    private HomeApplianceRepositoryGateway homeApplianceRepository;

    public Long create(HomeAppliance homeAppliance) {
        log.trace("Start homeAppliance={}", homeAppliance);

        Long homeApplianceId = homeApplianceRepository.create(homeAppliance);

        log.trace("End homeApplianceId={}", homeApplianceId);
        return homeApplianceId;
    }
}
