package com.grupo16.techchallenge.usuario.gateway.repository.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Embeddable
public class ParentescoId {
	
	@EqualsAndHashCode.Include
	@Column(name = "UsuarioPrincipal_Id")
	private Long usuarioPrincipalId;

	@EqualsAndHashCode.Include
	@Column(name = "UsuarioParente_Id")
	private Long usuarioParenteId;

}
