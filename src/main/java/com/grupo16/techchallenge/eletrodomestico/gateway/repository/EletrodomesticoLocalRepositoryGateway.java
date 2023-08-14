package com.grupo16.techchallenge.eletrodomestico.gateway.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;
import com.grupo16.techchallenge.eletrodomestico.gateway.EletrodomesticoRepositoryGateway;
import com.grupo16.techchallenge.eletrodomestico.gateway.exception.ErrorToAccessDatabaseException;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Repository
public class EletrodomesticoLocalRepositoryGateway implements EletrodomesticoRepositoryGateway {

    private Long sequenceId = 1L;

    private Set<Eletrodomestico> homeAppliances;

    public EletrodomesticoLocalRepositoryGateway() {
        homeAppliances = new HashSet<>();
    }

    @Override
    public Long criar(Eletrodomestico homeAppliance) {
    	try {
    		log.trace("Start homeAppliance={}", homeAppliance);
    		homeAppliance.setId(sequenceId++);
    		
    		homeAppliances.add(homeAppliance);
    		Long homeApplianceId = homeAppliance.getId();
    		
    		log.trace("End homeApplianceId={}", homeApplianceId);
    		return homeApplianceId;
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErrorToAccessDatabaseException();
		}
    }
}
