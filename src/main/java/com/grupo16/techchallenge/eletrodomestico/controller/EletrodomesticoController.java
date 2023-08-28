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
import com.grupo16.techchallenge.eletrodomestico.usecase.RegistrarConsumoEletrodomesticoUseCase;
import com.grupo16.techchallenge.eletrodomestico.usecase.RemoverEletrodomesticoUseCase;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/eletrodomesticos")
public class EletrodomesticoController {

	@Autowired
	private CriarAlterarEletrodomesticoUseCase criarAlterarEletrodomesticoUseCase;

	@Autowired
	private RemoverEletrodomesticoUseCase removerEletrodomesticoUseCase;

	@Autowired
	private RegistrarConsumoEletrodomesticoUseCase registrarConsumoEletrodomesticoUseCase;
	
	@Autowired
	private ObterEletrodomesticoUseCase obterEletrodomesticoUseCase;
	
	@Autowired
	private ObterConsumoUseCase obterConsumoUseCase;
	
	@GetMapping
	@RequestMapping("/filtro")
	public List<EletrodomesticoJson> buscaFiltrada(
			@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "modelo", required = false) String modelo,
			@RequestParam(name = "marca", required = false) String marca,
			@RequestParam(name = "potencia", required = false) Long potencia
			) {
		log.trace("Start nome={}, modelo={}, marca={}, potencia={}", nome, modelo, marca, potencia);

		var eletrodomestico = obterEletrodomesticoUseCase.buscaFiltrada(nome, modelo, marca, potencia);
		var eletrodomesticoJson = eletrodomestico.stream().map(EletrodomesticoJson::new).toList();

		log.trace("End eletrodomestico={}", eletrodomesticoJson);
		return eletrodomesticoJson;
	}

//	@GetMapping
//	public ResponseEntity<Page<EletrodomesticoJson>> obterTodos(
//			@RequestParam(name = "page", defaultValue = "0") Integer page,
//			@RequestParam(name = "linesPerPage", defaultValue = "10") Integer linesPerPage) {
//		log.trace("Start page={}, linesPerPage={}", page, linesPerPage);
//
//		PageRequest pageRequest = PageRequest.of(page, linesPerPage);
//		Page<EletrodomesticoJson> eletrodomesticos = obterEletrodomesticoUseCase.obterTodos(pageRequest);
//
//		log.trace("End eletrodomesticos={}", eletrodomesticos);
//		return ResponseEntity.ok(eletrodomesticos);
//	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Long criar(
			@Valid
			@RequestBody(required = true) EletrodomesticoJson eletrodomesticoJson) {
		log.trace("Start eletrodomesticoJson={}", eletrodomesticoJson);

		Eletrodomestico eletrodomestico = eletrodomesticoJson.mapearParaEletrodomesticoDomain();
		Long eletrodomesticoId = criarAlterarEletrodomesticoUseCase.criar(eletrodomestico);

		log.trace("End eletrodomesticoId={}", eletrodomesticoId);
		return eletrodomesticoId;
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping
	public void alterar(
			@RequestBody(required = true) EletrodomesticoJson eletrodomesticoJson) {
		log.trace("Start eletrodomesticoJson={}", eletrodomesticoJson);

		Eletrodomestico eletrodomestico = eletrodomesticoJson.mapearParaEletrodomesticoDomain();

		criarAlterarEletrodomesticoUseCase.alterar(eletrodomestico);

		log.trace("End");
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	public void remover(
			@PathVariable(name = "id") Long id) {
		log.trace("Start id={}", id);

		removerEletrodomesticoUseCase.remover(id);

		log.trace("End");
	}

	@PostMapping("{id}/consumos")
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
	
	@GetMapping("{id}/consumo-total-periodo")
	public Double pesquisarRegistroConsumo(
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
		
		log.trace("End consumo={}", consumo);
		return consumo;
	}
}
