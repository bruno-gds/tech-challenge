package com.grupo16.techchallenge.usuario.domain;

import java.time.LocalDate;
import java.util.List;

import com.grupo16.techchallenge.endereco.domain.Endereco;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@ToString
public class Usuario {
	
	@Setter
	protected Long id;
	protected String nome;
	protected String cpf;
	protected LocalDate dataNascimento;
	protected Genero genero;	
	protected List<Endereco> enderecos;
	private List<Parente> parentes;
}
