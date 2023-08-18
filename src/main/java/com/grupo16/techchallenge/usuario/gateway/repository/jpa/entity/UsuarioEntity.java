package com.grupo16.techchallenge.usuario.gateway.repository.jpa.entity;

import java.time.LocalDate;
import java.util.List;

import com.grupo16.techchallenge.endereco.gateway.repository.jpa.entity.EnderecoEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "Usuario")
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private int genero;
	
	@OneToMany(mappedBy = "usuario")
	private List<EnderecoEntity> enderecos;
	
}
