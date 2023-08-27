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
	
	public boolean hasNome() {
		return nome != null && !nome.isEmpty();
	}

	public boolean hasCpf() {
		return cpf != null && !cpf.isEmpty();
	}

	public boolean hasParentesco() {
		return parentesco != null;
	}

	public boolean hasGenero() {
		return genero != null;
	}

	public boolean hasDataNascimento() {
		return dataNascimento != null;
	}

}
