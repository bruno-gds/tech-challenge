package com.grupo16.techchallenge.usuario.controller.json;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.grupo16.techchallenge.usuario.domain.Genero;
import com.grupo16.techchallenge.usuario.domain.Parentesco;
import com.grupo16.techchallenge.usuario.domain.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
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
	private List<ParentescoJson> parentes;
	
	
	
	public Usuario mapearParaUsuarioDomain() {
		List<Parentesco> usuariosParentes = new ArrayList<>();
		if(parentes != null) {
			usuariosParentes = parentes.stream().map(p -> p.mapearParentescoJsonParaDomain()).toList();
		}
		
		return Usuario.builder()
				.id(id)
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

	public UsuarioJson(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
		this.dataNascimento = usuario.getDataNascimento();
		this.genero = usuario.getGenero().name();
	}
}
