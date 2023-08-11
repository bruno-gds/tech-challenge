package com.grupo16.techchallenge.eletrodomestico.gateway;

import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;

public interface HomeApplianceRepositoryGateway {

    public Long create(Eletrodomestico homeAppliance);
}
