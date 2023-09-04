package com.grupo16.techchallenge.endereco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.techchallenge.endereco.controller.json.EnderecoJson;
import com.grupo16.techchallenge.endereco.domain.Endereco;
import com.grupo16.techchallenge.endereco.domain.Estado;
import com.grupo16.techchallenge.endereco.dto.PesquisarEnderecoParamsDto;
import com.grupo16.techchallenge.endereco.usecase.CriarAlterarEnderecoUseCase;
import com.grupo16.techchallenge.endereco.usecase.ObterEnderecoUseCase;
import com.grupo16.techchallenge.endereco.usecase.RemoverEnderecoUseCase;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping()
public class EnderecoController {

	@Autowired	
	private CriarAlterarEnderecoUseCase criarAlterarEnderecoUseCase;

	@Autowired	
	private ObterEnderecoUseCase obterEnderecoUseCase;

	@Autowired	
	private RemoverEnderecoUseCase removerEnderecoUseCase;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("usuarios/{idUsuario}/enderecos")
	public Long criar(
			@PathVariable(name = "idUsuario", required = true) Long idUsuario, 
			@Valid @RequestBody(required = true) EnderecoJson enderecoJson) {
		log.trace("Start idUsuario={}, enderecoJson={}", idUsuario, enderecoJson);

		Endereco endereco = enderecoJson.mapearParaEnderecoDomain(null, idUsuario);
		Long id = criarAlterarEnderecoUseCase.criar(endereco);

		log.trace("End id={}", id);
		return id;
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("usuarios/{idUsuario}/enderecos/{idEndereco}")
	public void alterar(
			@PathVariable(name = "idEndereco", required = true) Long idEndereco, 
			@PathVariable(name = "idUsuario", required = true) Long idUsuario, 
			@Valid @RequestBody(required = true) EnderecoJson enderecoJson) {
		log.trace("Start idEndereco={}, idUsuario={}, enderecoJson={}",idEndereco, idUsuario, enderecoJson);

		Endereco endereco = enderecoJson.mapearParaEnderecoDomain(idEndereco, idUsuario);

		criarAlterarEnderecoUseCase.alterar(endereco);

		log.trace("End");
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("usuarios/{idUsuario}/enderecos/{idEndereco}")
	public void remover(
			@PathVariable(name = "idEndereco", required = true) Long idEndereco,
			@PathVariable(name = "idUsuario", required = true) Long idUsuario) { 
		log.trace("Start idEndereco={}, idUsuario={}", idEndereco, idUsuario);

		removerEnderecoUseCase.remover(idEndereco, idUsuario);

		log.trace("End");
	}

	@GetMapping("usuarios/{idUsuario}/enderecos")
	public List<EnderecoJson> pesquisar(
			@PathVariable(name = "idUsuario", required = true) Long idUsuario,
			@RequestParam(name = "rua", required = false) String rua,
			@RequestParam(name = "bairro", required = false) String bairro,
			@RequestParam(name = "cidade", required = false) String cidade,
			@RequestParam(name = "estado", required = false) String estado,
			@RequestParam(name = "cep", required = false) String cep){
		log.trace("Start idUsuario={}, rua={}, bairro={}, cidade={}, estado={}, cep={}", idUsuario, rua, bairro, cidade, estado, cep);

		PesquisarEnderecoParamsDto paramsDto = PesquisarEnderecoParamsDto.builder()
				.idUsuario(idUsuario)
				.rua(rua)
				.bairro(bairro)
				.cidade(cidade)
				.estado(estado == null ? null : Estado.valueOf(estado))
				.cep(cep)
				.build();

		List<Endereco> enderecos = obterEnderecoUseCase.pesquisar(paramsDto);

		List<EnderecoJson> enderecosJson = enderecos.stream().map(EnderecoJson::new).toList();

		log.trace("End enderecosJson={}", enderecosJson);

		return enderecosJson;
	}

}
