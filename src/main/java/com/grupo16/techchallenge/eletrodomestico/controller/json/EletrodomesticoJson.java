package com.grupo16.techchallenge.eletrodomestico.controller.json;

import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;
import com.grupo16.techchallenge.endereco.controller.json.EnderecoJson;
import com.grupo16.techchallenge.endereco.domain.Endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EletrodomesticoJson {

    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String modelo;

    @NotBlank
    private String marca;

    private String cor;

    @NotNull
    private Long potencia;

    @NotNull
    private Long voltagem;

    private EnderecoJson endereco;

    public EletrodomesticoJson(Eletrodomestico eletrodomestico) {
        this.id = eletrodomestico.getId();
        this.nome = eletrodomestico.getNome();
        this.modelo = eletrodomestico.getModelo();
        this.marca = eletrodomestico.getMarca();
        this.cor = eletrodomestico.getCor();
        this.potencia = eletrodomestico.getPotencia();
        this.voltagem = eletrodomestico.getVoltagem();
        this.endereco = EnderecoJson.builder()
                .id(eletrodomestico.getEndereco().getId())
                .build();
    }


    public Eletrodomestico mapearParaEletrodomesticoDomain(Long id, Long idEndereco) {
        return Eletrodomestico.builder()
                .id(id != null ? id : this.id)
                .nome(nome)
                .modelo(modelo)
                .marca(marca)
                .cor(cor)
                .potencia(potencia)
                .voltagem(voltagem)
                .endereco(Endereco.builder()
                        .id(idEndereco != null ? idEndereco : this.endereco.getId())
                        .build())
                .build();
    }
}
