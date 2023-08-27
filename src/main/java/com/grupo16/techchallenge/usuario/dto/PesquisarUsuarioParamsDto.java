package com.grupo16.techchallenge.usuario.dto;

import java.time.LocalDate;

import com.grupo16.techchallenge.usuario.domain.Genero;
import com.grupo16.techchallenge.usuario.domain.TipoParentesco;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PesquisarUsuarioParamsDto {
	
	private Long idUsuarioPrincipal;
	private String nome; 
	private String cpf;
	private TipoParentesco parentesco; 
	private LocalDate dataNascimento; 
	private Genero genero;

}
