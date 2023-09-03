package com.grupo16.techchallenge.eletrodomestico.gateway;

import java.util.List;
import java.util.Optional;

import com.grupo16.techchallenge.eletrodomestico.domain.LeituraConsumo;
import com.grupo16.techchallenge.eletrodomestico.dto.ConsumoEletrodomesticoParamsDto;

public interface LeituraConsumoRepositoryGateway {
	
	Long salvar(LeituraConsumo leituraConsumo);

	List<LeituraConsumo> pesquisar(ConsumoEletrodomesticoParamsDto paramsDto);

	Optional<LeituraConsumo> obterUltimaLeituraPorEletrodomesticoId(Long eletrodomesticoId);

	void remover(Long idEletrodomestico);

}
