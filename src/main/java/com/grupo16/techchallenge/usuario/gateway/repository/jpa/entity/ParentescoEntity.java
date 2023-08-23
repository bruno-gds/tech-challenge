package com.grupo16.techchallenge.usuario.gateway.repository.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Parentesco")
@Getter
public class ParentescoEntity {
	
	@EmbeddedId
	private ParentescoId parentescoId;
	
	@Column(name = "TipoParentesco_Id")
	private Long tipoParentescoId;
	
	@ManyToOne
	@JoinColumn(name = "UsuarioPrincipal_Id",insertable=false, updatable=false)
	private UsuarioEntity usuarioPrincipal;

	@ManyToOne
	@JoinColumn(name = "UsuarioParente_Id",insertable=false, updatable=false)
	private UsuarioEntity usuarioParente;
	

}
