package com.grupo16.techchallenge.eletrodomestico.usecase;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;
import com.grupo16.techchallenge.eletrodomestico.gateway.HomeApplianceRepositoryGateway;
import com.grupo16.techchallenge.eletrodomestico.usecase.exception.IllegalArgumentVoltageException;

@Slf4j
@Service
public class HomeApplianceUseCase {

    @Autowired
    private HomeApplianceRepositoryGateway homeApplianceRepository;

    public Long create(Eletrodomestico homeAppliance) {
        log.trace("Start homeAppliance={}", homeAppliance);

        if (!homeAppliance.getVoltagem().equals(110L) && !homeAppliance.getVoltagem().equals(220L)) {
            log.warn("Voltagem inválida: {}", homeAppliance.getVoltagem());
            throw new IllegalArgumentVoltageException();
        }

        Long homeApplianceId = homeApplianceRepository.create(homeAppliance);

        log.trace("End homeApplianceId={}", homeApplianceId);
        return homeApplianceId;
    }
}
