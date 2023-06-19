package com.grupo16.techchallenge.homeAppliance.gateway.repository;

import com.grupo16.techchallenge.homeAppliance.domain.HomeAppliance;
import com.grupo16.techchallenge.homeAppliance.gateway.HomeApplianceRepositoryGateway;
import com.grupo16.techchallenge.homeAppliance.gateway.exception.ErrorToAccessDatabaseException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Repository
public class HomeApplianceLocalRepositoryGateway implements HomeApplianceRepositoryGateway {

    private Long sequenceId = 1L;

    private Set<HomeAppliance> homeAppliances;

    public HomeApplianceLocalRepositoryGateway() {
        homeAppliances = new HashSet<>();
    }

    @Override
    public Long create(HomeAppliance homeAppliance) {
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
