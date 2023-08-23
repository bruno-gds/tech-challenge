package com.grupo16.techchallenge.usuario.gateway.repository.jpa.entity;

import com.grupo16.techchallenge.usuario.domain.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "Parentesco")
@Getter
public class ParentescoEntity {
	
	@EmbeddedId
	private ParentescoId parentescoId;
	
	@Column(name = "TipoParentesco_Id")
	private Long tipoParentescoId;//TODO: criar Enum
	
	@ManyToOne
	@JoinColumn(name = "UsuarioPrincipal_Id")
	private Usuario usuarioPrincipal;

	@ManyToOne
	@JoinColumn(name = "UsuarioParente_Id")
	private Usuario usuarioParente;
	

}
