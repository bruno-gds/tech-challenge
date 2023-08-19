package com.grupo16.techchallenge.usuario.controller.json;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.grupo16.techchallenge.usuario.domain.Genero;
import com.grupo16.techchallenge.usuario.domain.Parente;
import com.grupo16.techchallenge.usuario.domain.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class UsuarioJson {
	
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotNull
	@CPF
	private String cpf;
	
	@Past
	private LocalDate dataNascimento;

	@NotBlank
	private String genero;
	private List<ParenteJson> parentes;
	
	public Usuario mapearParaUsuarioDomain() {
		List<Parente> usuariosParentes = new ArrayList<>();
		if(parentes != null) {
			usuariosParentes = parentes.stream().map(p -> p.mapearParaParenteDomain()).toList();
		}
		
		return Usuario.builder()
				.nome(nome)
				.cpf(removeMask(cpf))
				.dataNascimento(dataNascimento)
				.genero(Genero.valueOf(genero))
				.parentes(usuariosParentes)
				.build();
		
	}
	
	private String removeMask(String cpf) {
		return cpf.replace(".", "").replace("-", "").replace(" ", "");
	}
}
