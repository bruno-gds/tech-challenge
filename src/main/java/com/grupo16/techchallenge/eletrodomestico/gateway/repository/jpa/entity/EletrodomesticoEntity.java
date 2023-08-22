package com.grupo16.techchallenge.eletrodomestico.gateway.repository.jpa.entity;

import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;
import com.grupo16.techchallenge.endereco.domain.Endereco;
import com.grupo16.techchallenge.endereco.gateway.repository.jpa.entity.EnderecoEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 15/08/2023
 * Project Name: tech-challenge
 */

@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Eletrodomestico")
public class EletrodomesticoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String modelo;
    private String marca;
    private String cor;
    private Long potencia;
    private Long voltagem;

    @ManyToOne
    @JoinColumn(name = "Endereco_id")
    private EnderecoEntity endereco;

//    private List<MedicaoConsumo> medicoesConsumo;


    public EletrodomesticoEntity(Eletrodomestico eletrodomestico) {
        this.id = eletrodomestico.getId();
        this.nome = eletrodomestico.getNome();
        this.modelo = eletrodomestico.getModelo();
        this.marca = eletrodomestico.getMarca();
        this.cor = eletrodomestico.getCor();
        this.potencia = eletrodomestico.getPotencia();
        this.voltagem = eletrodomestico.getVoltagem();
        this.endereco = EnderecoEntity.builder()
                .id(eletrodomestico.getEndereco().getId())
                .build();
    }

    public Eletrodomestico mapToDomain() {
        return Eletrodomestico.builder()
                .id(id)
                .nome(nome)
                .modelo(modelo)
                .marca(marca)
                .cor(cor)
                .potencia(potencia)
                .voltagem(voltagem)
//                .endereco(Endereco.builder()
//                        .id(this.endereco.getId())
//                        .build())
                .build();
    }
}
