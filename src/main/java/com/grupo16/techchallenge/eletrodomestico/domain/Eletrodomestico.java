package com.grupo16.techchallenge.eletrodomestico.domain;

import java.util.List;

import com.grupo16.techchallenge.endereco.domain.Endereco;

import lombok.*;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Eletrodomestico {

    private Long id;
    private String nome;
    private String modelo;
    private String marca;
    private String cor;
    private Long potencia;
    private Long voltagem;
    private Endereco endereco;
    private List<MedicaoConsumo> medicoesConsumo;
}
