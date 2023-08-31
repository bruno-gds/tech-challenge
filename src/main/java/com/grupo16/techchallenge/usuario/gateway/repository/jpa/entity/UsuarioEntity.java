package com.grupo16.techchallenge.usuario.gateway.repository.jpa.entity;

import java.time.LocalDate;
import java.util.List;

import com.grupo16.techchallenge.endereco.gateway.repository.jpa.entity.EnderecoEntity;
import com.grupo16.techchallenge.usuario.domain.Genero;
import com.grupo16.techchallenge.usuario.domain.Parente;
import com.grupo16.techchallenge.usuario.domain.TipoParentesco;
import com.grupo16.techchallenge.usuario.domain.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Usuario")
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private int genero;
	
	@OneToMany(mappedBy = "usuario")
	private List<EnderecoEntity> enderecos;

	@Setter
	private Long parenteId;
	
	@Setter
	private Long tipoParentesco;
	
	public UsuarioEntity(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
		this.dataNascimento = usuario.getDataNascimento();
		this.genero = usuario.getGenero().ordinal();
	}
	
	public Usuario mapearUsuarioEntityParaDomain() {
		
		if(tipoParentesco == null) {
			return Usuario.builder()
					.id(id)
					.nome(nome)
					.cpf(cpf)
					.dataNascimento(dataNascimento)
					.genero(Genero.getByOrdinal(genero))
					.build();
		} else {
			return Parente.builder()
					.id(id)
					.nome(nome)
					.cpf(cpf)
					.dataNascimento(dataNascimento)
					.genero(Genero.getByOrdinal(genero))
					.parentesco(TipoParentesco.getByOrdinal(tipoParentesco.intValue()))
					.usuarioPrinpal(Usuario.builder().id(parenteId).build())
					.build();
			
		}
		
		
	}
}
