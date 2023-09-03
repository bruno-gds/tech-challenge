package com.grupo16.techchallenge.eletrodomestico.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.techchallenge.eletrodomestico.controller.json.EletrodomesticoJson;
import com.grupo16.techchallenge.eletrodomestico.controller.json.LeituraConsumoJson;
import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;
import com.grupo16.techchallenge.eletrodomestico.domain.LeituraConsumo;
import com.grupo16.techchallenge.eletrodomestico.dto.ConsumoEletrodomesticoParamsDto;
import com.grupo16.techchallenge.eletrodomestico.usecase.CriarAlterarEletrodomesticoUseCase;
import com.grupo16.techchallenge.eletrodomestico.usecase.ObterConsumoUseCase;
import com.grupo16.techchallenge.eletrodomestico.usecase.ObterEletrodomesticoUseCase;
import com.grupo16.techchallenge.eletrodomestico.usecase.RegistrarConsumoUseCase;
import com.grupo16.techchallenge.eletrodomestico.usecase.RemoverEletrodomesticoUseCase;
import com.grupo16.techchallenge.eletrodomestico.usecase.RemoverRegistroConsumoUseCase;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping()
public class EletrodomesticoController {

	@Autowired
	private CriarAlterarEletrodomesticoUseCase criarAlterarEletrodomesticoUseCase;

	@Autowired
	private RemoverEletrodomesticoUseCase removerEletrodomesticoUseCase;

	@Autowired
	private RegistrarConsumoUseCase registrarConsumoEletrodomesticoUseCase;

	@Autowired
	private RemoverRegistroConsumoUseCase removerRegistroConsumoUseCase;
	
	@Autowired
	private ObterEletrodomesticoUseCase obterEletrodomesticoUseCase;
	
	@Autowired
	private ObterConsumoUseCase obterConsumoUseCase;
	
	@GetMapping
	@RequestMapping("usuarios/{idUsuario}/eletrodomesticos")
	public List<EletrodomesticoJson> buscaFiltrada(
			@PathVariable(name = "idUsuario") Long idUsuario,
			@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "modelo", required = false) String modelo,
			@RequestParam(name = "marca", required = false) String marca,
			@RequestParam(name = "potencia", required = false) Long potencia) {
		log.trace("Start idUsuario={}, nome={}, modelo={}, marca={}, potencia={}", idUsuario, nome, modelo, marca, potencia);

		var eletrodomestico = obterEletrodomesticoUseCase.buscaFiltrada(idUsuario, nome, modelo, marca, potencia);
		var eletrodomesticoJson = eletrodomestico.stream().map(EletrodomesticoJson::new).toList();

		log.trace("End eletrodomestico={}", eletrodomesticoJson);
		return eletrodomesticoJson;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("enderecos/{idEndereco}/eletrodomesticos")
	public Long criar(
			@PathVariable(name = "idEndereco", required = true) Long idEndereco,
			@Valid @RequestBody(required = true) EletrodomesticoJson eletrodomesticoJson) {
		log.trace("Start eletrodomesticoJson={}", eletrodomesticoJson);

		Eletrodomestico eletrodomestico = eletrodomesticoJson.mapearParaEletrodomesticoDomain(null, idEndereco);
		Long eletrodomesticoId = criarAlterarEletrodomesticoUseCase.criar(eletrodomestico);

		log.trace("End eletrodomesticoId={}", eletrodomesticoId);
		return eletrodomesticoId;
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("usuarios/{idUsuario}/eletrodomesticos/{idEletrodomestico}")
	public void alterar(
			@PathVariable(name = "idEletrodomestico") Long idEletrodomestico,
			@PathVariable(name = "idUsuario", required = true) Long idUsuario,
			@Valid @RequestBody EletrodomesticoJson eletrodomesticoJson) {
		log.trace("Start eletrodomesticoJson={}", eletrodomesticoJson);

		Eletrodomestico eletrodomestico = eletrodomesticoJson.mapearParaEletrodomesticoDomain(idEletrodomestico,idUsuario);

		criarAlterarEletrodomesticoUseCase.alterar(eletrodomestico);

		log.trace("End");
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("usuarios/{idUsuario}/eletrodomesticos/{idEletrodomestico}")
	public void remover(
			@PathVariable(name = "idUsuario", required = true) Long idUsuario,
			@PathVariable(name = "idEletrodomestico") Long idEletrodomestico) {
		log.trace("Start idUsuario={}, idEletrodomestico={}", idUsuario, idEletrodomestico);

		removerEletrodomesticoUseCase.remover(idEletrodomestico, idUsuario);

		log.trace("End");
	}

	@PostMapping("eletrodomesticos/{id}/consumos")
	public Long registrarConsumo(
			@PathVariable(name = "id", required = true) Long eletrodomesticoId,
			@RequestBody(required = true) LeituraConsumoJson leituraConsumoJson ) {
		log.trace("Start leituraConsumoJson={}", leituraConsumoJson);

		Eletrodomestico eletrodomestico = Eletrodomestico.builder().id(eletrodomesticoId).build();
		LeituraConsumo leituraConsumo = LeituraConsumo.builder()
				.consumo(leituraConsumoJson.getConsumo())
				.eletrodomestico(eletrodomestico)
				.build();

		Long registroId = registrarConsumoEletrodomesticoUseCase.registrar(leituraConsumo);

		log.trace("End registroId={}",registroId);
		return registroId;
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("usuarios/{idUsuario}/eletrodomesticos/{idEletrodomestico}/consumos")
	public void removerConsumo(
			@PathVariable(name = "idUsuario", required = true) Long idUsuario,
			@PathVariable(name = "idEletrodomestico", required = true) Long eletrodomesticoId) {
		log.trace("Start idUsuario={}, eletrodomesticoId={}", idUsuario, eletrodomesticoId);
		
		removerRegistroConsumoUseCase.remover(eletrodomesticoId, idUsuario);
		log.trace("End");
	}
	
	@GetMapping("eletrodomesticos/{id}/consumo-total-periodo")
	public String pesquisarRegistroConsumo(
			@PathVariable(name = "id", required = true) Long eletrodomesticoId,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @RequestParam(name = "dataInicio", required = false) LocalDateTime dataInicio,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @RequestParam(name = "dataFim", required = false) LocalDateTime dataFim) {
		
		log.trace("Start eletrodomesticoId={}, dataInicio={}, dataFim={}", eletrodomesticoId, dataInicio, dataFim);
		
		ConsumoEletrodomesticoParamsDto paramDto = ConsumoEletrodomesticoParamsDto.builder()
					.eletrodomesticoId(eletrodomesticoId)
					.dataInicio(dataInicio)
					.dataFim(dataFim)
				.build();
		
		Double consumo = obterConsumoUseCase.obter(paramDto);
		
		String consumoStr = consumo + " kWh";
		
		log.trace("End consumo={}", consumoStr);
		return consumoStr;
	}
}
