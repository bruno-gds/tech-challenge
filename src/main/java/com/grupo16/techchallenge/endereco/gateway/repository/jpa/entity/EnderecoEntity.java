package com.grupo16.techchallenge.endereco.gateway.repository.jpa.entity;

import java.util.List;

import com.grupo16.techchallenge.eletrodomestico.gateway.repository.jpa.entity.EletrodomesticoEntity;
import com.grupo16.techchallenge.endereco.domain.Endereco;
import com.grupo16.techchallenge.endereco.domain.Estado;
import com.grupo16.techchallenge.usuario.domain.Genero;
import com.grupo16.techchallenge.usuario.domain.Usuario;
import com.grupo16.techchallenge.usuario.gateway.repository.jpa.entity.UsuarioEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Endereco")
public class EnderecoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private Long estado;
	private String cep;

	@ManyToOne
	@JoinColumn(name = "Usuario_id")
	private UsuarioEntity usuario;

	@OneToMany(mappedBy = "endereco")
	private List<EletrodomesticoEntity> eletrodomesticos;


	public EnderecoEntity(Endereco endereco) {
		this.id = endereco.getId();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.estado = (long) endereco.getEstado().ordinal();
		this.cep = endereco.getCep();
		this.usuario = UsuarioEntity.builder()
				.id(endereco.getUsuario().getId())
				.build();
	}

	public Endereco mapToDomain() {
		return Endereco.builder()
				.id(id)
				.rua(rua)
				.numero(numero)
				.bairro(bairro)
				.cidade(cidade)
				.estado(Estado.getByOrdinal(estado.intValue()))
				.cep(cep)
				.usuario(Usuario.builder()
						.id(this.usuario.getId())
						.build())
				.build();
	}

}
