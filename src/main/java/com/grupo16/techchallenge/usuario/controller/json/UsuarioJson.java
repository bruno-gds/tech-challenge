package com.grupo16.techchallenge.usuario.controller.json;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.grupo16.techchallenge.endereco.controller.exception.IllegalArgumentParentescoException;
import com.grupo16.techchallenge.usuario.domain.Genero;
import com.grupo16.techchallenge.usuario.domain.Parente;
import com.grupo16.techchallenge.usuario.domain.TipoParentesco;
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
@JsonInclude(Include.NON_NULL)
public class UsuarioJson {
	
	private Long id;
	private Long idUsuarioPrincipal;
	
	@NotBlank
	private String nome;
	
	@NotNull
	@CPF
	private String cpf;
	
	@Past
	private LocalDate dataNascimento;

	@NotBlank
	private String genero;
	private List<UsuarioJson> parentes;
	
	private TipoParentesco parentesco;
	
	public Usuario mapearParaUsuarioDomain(Long id) {
		return Usuario.builder()
				.id(id != null ? id : this.id)
				.nome(nome)
				.cpf(removeMask(cpf))
				.dataNascimento(dataNascimento)
				.genero(Genero.valueOf(genero))
				.build();
	}
	
	public Usuario mapearParaParenteDomain(Long id) {
		
		if(parentesco == null) {
			throw new IllegalArgumentParentescoException();
		}
		
		return Parente.builder()
				.id(id != null ? id : this.id)
				.nome(nome)
				.cpf(removeMask(cpf))
				.dataNascimento(dataNascimento)
				.genero(Genero.valueOf(genero))
				.parentesco(parentesco)
				.usuarioPrinpal(Usuario.builder().id(idUsuarioPrincipal).build())
				.build();
	}
	
	public UsuarioJson(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
		this.dataNascimento = usuario.getDataNascimento();
		this.genero = usuario.getGenero().name();

		if(usuario instanceof Parente) {
			Parente parente = (Parente) usuario;
			this.parentesco = parente.getParentesco();
		}
	}

	private String removeMask(String cpf) {
		return cpf.replace(".", "").replace("-", "").replace(" ", "");
	}
}
