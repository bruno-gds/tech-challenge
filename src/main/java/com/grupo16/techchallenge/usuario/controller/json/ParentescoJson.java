package com.grupo16.techchallenge.usuario.controller.json;

import com.grupo16.techchallenge.usuario.domain.Genero;
import com.grupo16.techchallenge.usuario.domain.Parentesco;
import com.grupo16.techchallenge.usuario.domain.TipoParentesco;
import com.grupo16.techchallenge.usuario.domain.Usuario;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ParentescoJson {
	
	@NotBlank
	private UsuarioJson usuario;
	@NotBlank
	private UsuarioJson usuarioParente;
	@NotBlank
	private String tipoParentesco;
	
	public Parentesco mapearParentescoJsonParaDomain() {
		return Parentesco.builder()
				.usuarioParente(Usuario.builder()
						.nome(usuarioParente.getNome())
						.cpf(removeMask(usuarioParente.getCpf()))
						.dataNascimento(usuarioParente.getDataNascimento())
						.genero(Genero.valueOf(usuarioParente.getGenero()))
						.build())
				.tipoParentesco(TipoParentesco.valueOf(tipoParentesco))
				.usuario(Usuario.builder()
						.id(usuario.getId())
						.build())
				.build();
	}
	
	private String removeMask(String cpf) {
		return cpf.replace(".", "").replace("-", "").replace(" ", "");
	}

}
