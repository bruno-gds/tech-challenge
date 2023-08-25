package com.grupo16.techchallenge.eletrodomestico.controller;

import com.grupo16.techchallenge.eletrodomestico.controller.json.EletrodomesticoJson;
import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;
import com.grupo16.techchallenge.eletrodomestico.usecase.CriarAlterarEletrodomesticoUseCase;

import com.grupo16.techchallenge.eletrodomestico.usecase.ObterEletrodomesticoUseCase;
import com.grupo16.techchallenge.eletrodomestico.usecase.RemoverEletrodomesticoUseCase;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/eletrodomesticos")
public class EletrodomesticoController {

    @Autowired
    private CriarAlterarEletrodomesticoUseCase criarAlterarEletrodomesticoUseCase;

    @Autowired
    private ObterEletrodomesticoUseCase obterEletrodomesticoUseCase;

    @Autowired
    private RemoverEletrodomesticoUseCase removerEletrodomesticoUseCase;

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

    @GetMapping
    public ResponseEntity<Page<EletrodomesticoJson>> obterTodos(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "linesPerPage", defaultValue = "10") Integer linesPerPage
    ) {
        log.trace("Start page={}, linesPerPage={}", page, linesPerPage);

        PageRequest pageRequest = PageRequest.of(page, linesPerPage);
        Page<EletrodomesticoJson> eletrodomesticos = obterEletrodomesticoUseCase.obterTodos(pageRequest);

        log.trace("End eletrodomesticos={}", eletrodomesticos);
        return ResponseEntity.ok(eletrodomesticos);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Long criar(
            @Valid
            @RequestBody
            EletrodomesticoJson eletrodomesticoJson) {
        log.trace("Start eletrodomesticoJson={}", eletrodomesticoJson);

        Eletrodomestico eletrodomestico = eletrodomesticoJson.mapeandoParaEletrodomestico();
        Long eletrodomesticoId = criarAlterarEletrodomesticoUseCase.criar(eletrodomestico);

        log.trace("End eletrodomesticoId={}", eletrodomesticoId);
        return eletrodomesticoId;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping
    public void alterar(
        @RequestBody EletrodomesticoJson eletrodomesticoJson
    ) {
        log.trace("Start eletrodomesticoJson={}", eletrodomesticoJson);

        Eletrodomestico eletrodomestico = eletrodomesticoJson.mapeandoParaEletrodomestico();

        criarAlterarEletrodomesticoUseCase.alterar(eletrodomestico);

        log.trace("End");
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void remover(
    		@PathVariable(name = "id") Long id
    ) {
        log.trace("Start id={}", id);

        removerEletrodomesticoUseCase.remover(id);

        log.trace("End");
    }
}
