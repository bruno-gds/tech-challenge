package com.grupo16.techchallenge.usuario.controller.json;

import com.grupo16.techchallenge.usuario.domain.Genero;
import com.grupo16.techchallenge.usuario.domain.Parentesco;
import com.grupo16.techchallenge.usuario.domain.Usuario;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ParentescoJson {
	
	private UsuarioJson usuario;
	private UsuarioJson usuarioParente;
	private String tipoParentesco;
	
	public Parentesco mapearParentescoJsonParaDomain() {
		return Parentesco.builder()
				.usuarioParente(Usuario.builder()
						.nome(usuarioParente.getNome())
						.cpf(usuarioParente.getCpf())
						.dataNascimento(usuarioParente.getDataNascimento())
						.genero(Genero.valueOf(usuarioParente.getGenero()))
						.build())
				.tipoParentesco(tipoParentesco)
				.usuario(Usuario.builder()
						.id(usuario.getId())
						.build())
				.build();
	}

}
