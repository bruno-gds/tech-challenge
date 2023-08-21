package com.grupo16.techchallenge.eletrodomestico.controller;

import com.grupo16.techchallenge.eletrodomestico.controller.json.EletrodomesticoJson;
import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;
import com.grupo16.techchallenge.eletrodomestico.usecase.CriarAlterarEletrodomesticoUseCase;

import com.grupo16.techchallenge.eletrodomestico.usecase.RemoverEletrodomesticoUseCase;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/eletrodomesticos")
public class EletrodomesticoController {

    @Autowired
    private CriarAlterarEletrodomesticoUseCase criarAlterarEletrodomesticoUseCase;

    @Autowired
    private RemoverEletrodomesticoUseCase removerEletrodomesticoUseCase;

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
    @PatchMapping
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
