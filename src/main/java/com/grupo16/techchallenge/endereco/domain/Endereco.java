package com.grupo16.techchallenge.endereco.domain;

import java.util.List;

import com.grupo16.techchallenge.eletrodomestico.domain.Eletrodomestico;
import com.grupo16.techchallenge.user.domain.Usuario;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Endereco {

	@Setter
	private Long id;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private Estado estado;
	private Usuario usuario;
	private List<Eletrodomestico> eletrodomesticos;
}
