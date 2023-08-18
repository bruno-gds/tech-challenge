package com.grupo16.techchallenge.usuario.controller.json;

import com.grupo16.techchallenge.usuario.domain.Genero;
import com.grupo16.techchallenge.usuario.domain.Parente;
import com.grupo16.techchallenge.usuario.domain.Usuario;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ParenteJson {
	
	private Long id;
	private UsuarioJson usuario;
	private UsuarioJson usuarioParente;
	private String tipoParentesco;
	
	public Parente toParente() {
		return Parente.builder()
				.usuarioParente(Usuario.builder()
						.nome(usuarioParente.getNome())
						.cpf(usuarioParente.getCpf())
						.dataNascimento(usuarioParente.getDataNascimento())
						.genero(Genero.valueOf(usuarioParente.getGenero()))
						.build())
				.tipoParentesco(tipoParentesco)
				.build();
	}

}
