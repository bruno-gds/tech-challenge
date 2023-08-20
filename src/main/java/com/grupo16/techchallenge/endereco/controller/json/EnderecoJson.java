package com.grupo16.techchallenge.endereco.controller.json;

import com.grupo16.techchallenge.endereco.domain.Endereco;
import com.grupo16.techchallenge.endereco.domain.Estado;
import com.grupo16.techchallenge.usuario.controller.json.UsuarioJson;
import com.grupo16.techchallenge.usuario.domain.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoJson {
	
	private Long id;

	@NotBlank
    private String rua;

	@NotBlank
    private String numero;

	@NotBlank
    private String bairro;

	@NotBlank
    private String cidade;

	@NotBlank
	@Pattern(regexp = "^[A-Z]{2}$", message = "O estado deve estar no formato 'SP'")
    private String estado;

	@NotBlank
	@Size(min = 8, max = 8)
	private String cep;
	
	private UsuarioJson usuario;
	
    public Endereco mapearParaEnderecoDomain() {
    	Usuario usuario = Usuario.builder()
    			.id(this.usuario.getId())
    			.build();
    	
        return Endereco.builder()
        		.id(id)
        		.rua(rua)
        		.numero(numero)
        		.bairro(bairro)
        		.cidade(cidade)
        		.estado(Estado.valueOf(estado))
        		.cep(cep)
        		.usuario(usuario)
        		.build();
    }

	public EnderecoJson(Endereco endereco) {
		this.id = endereco.getId();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.estado = String.valueOf(endereco.getEstado());
		this.cep = endereco.getCep();
		this.usuario = UsuarioJson.builder()
				.id(endereco.getUsuario().getId())
				.build();
	}
}
