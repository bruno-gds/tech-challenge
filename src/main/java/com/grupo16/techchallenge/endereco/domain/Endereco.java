package com.grupo16.techchallenge.endereco.domain;

import java.util.List;

import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;
import com.grupo16.techchallenge.usuario.domain.Usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

	private Long id;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private Estado estado;
	private String cep;
	private Usuario usuario;
	private List<Eletrodomestico> eletrodomesticos;
}
