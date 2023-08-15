package com.grupo16.techchallenge.eletrodomestico.gateway.repository.jpa.entity;

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
    @JoinColumn(name = "Eletrodomestico_id")
    private EnderecoEntity endereco;
//    private List<MedicaoConsumo> medicoesConsumo;
}