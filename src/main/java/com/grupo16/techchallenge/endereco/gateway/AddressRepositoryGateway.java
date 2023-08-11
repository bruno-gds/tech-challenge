package com.grupo16.techchallenge.endereco.gateway;

import com.grupo16.techchallenge.endereco.domain.Endereco;

public interface AddressRepositoryGateway {
	
	public Long create(Endereco address);

}
