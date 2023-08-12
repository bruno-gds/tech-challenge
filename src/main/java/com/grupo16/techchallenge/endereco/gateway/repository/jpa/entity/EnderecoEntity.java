package com.grupo16.techchallenge.endereco.gateway.repository.jpa.entity;

import com.grupo16.techchallenge.endereco.domain.Endereco;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Endereco")
public class EnderecoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String rua;

	
	public EnderecoEntity(Endereco endereco) {
		this.id = endereco.getId();
		this.rua = endereco.getRua();
	}
	
}
