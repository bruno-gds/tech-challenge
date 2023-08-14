package com.grupo16.techchallenge.endereco.controller.json;

import com.grupo16.techchallenge.endereco.domain.Endereco;
import com.grupo16.techchallenge.endereco.domain.Estado;
import com.grupo16.techchallenge.user.domain.Usuario;

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
	
//	private UsuarioJson usuario;

	
//	public EnderecoJson(Endereco endereco) {
//		return EnderecoJson.
//	}
	
	
    public Endereco mapToDomain() {
    	//inserir o id usuario assim q a classe UsuarioJson estiver concluída.
    	Usuario usuario = Usuario.builder().id(null).build();    	
    	
        return Endereco.builder()
        		.rua(rua)
        		.numero(numero)
        		.bairro(bairro)
        		.cidade(cidade)
        		.estado(Estado.valueOf(estado))
        		.cep(cep)
//        		.usuario(usuario)
        		.build();
    }

	public EnderecoJson(Endereco endereco) {
		rua = endereco.getRua();
		numero = endereco.getNumero();
		bairro = endereco.getBairro();
		cidade = endereco.getCidade();
		estado = String.valueOf(endereco.getEstado());
		cep = endereco.getCep();
//		usuario = endereco.getUsuario();
		
	}
}
