package com.grupo16.techchallenge.user.domain;

import java.time.LocalDate;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Usuario {
	
	@Setter
	private Long id;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private Genero genero;	
	private List<Parentesco> parentes;
	
	
}
