package com.grupo16.techchallenge.endereco.controller.json;

import com.grupo16.techchallenge.endereco.domain.Endereco;
import com.grupo16.techchallenge.endereco.domain.Estado;
import com.grupo16.techchallenge.user.domain.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EnderecoJson {

	@NotBlank
    private String rua;

	@NotBlank
    private String numero;

	@NotBlank
    private String bairro;

	@NotBlank
    private String cidade;

	@NotNull
	@Pattern(regexp = "^[A-Z]{2}$", message = "O estado deve estar no formato 'SP'")
    private String estado;
	
//	private UsuarioJson usuario;

    public Endereco mapToEnderecoDomain() {
    	//inserir o id usuario assim q a classe UsuarioJson estiver concluída.
    	Usuario usuario = Usuario.builder().id(null).build();    	
    	
        return Endereco.builder()
        		.rua(rua)
        		.numero(numero)
        		.bairro(bairro)
        		.cidade(cidade)
        		.estado(Estado.valueOf(estado))
//        		.usuario(usuario)
        		.build();
    }
}
