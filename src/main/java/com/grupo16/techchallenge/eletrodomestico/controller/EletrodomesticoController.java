package com.grupo16.techchallenge.eletrodomestico.controller;

import com.grupo16.techchallenge.eletrodomestico.controller.json.EletrodomesticoJson;
import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;
import com.grupo16.techchallenge.eletrodomestico.usecase.EletrodomesticoUseCase;

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
    private EletrodomesticoUseCase eletrodomesticoUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Long create(
            @Valid
            @RequestBody
            EletrodomesticoJson eletrodomesticoJson) {
        log.trace("Start eletrodomesticoJson={}", eletrodomesticoJson);

        Eletrodomestico eletrodomestico = eletrodomesticoJson.mapeandoParaEletrodomestico();
        Long eletrodomesticoId = eletrodomesticoUseCase.criar(eletrodomestico);

        log.trace("End eletrodomesticoId={}", eletrodomesticoId);
        return eletrodomesticoId;
    }
}
