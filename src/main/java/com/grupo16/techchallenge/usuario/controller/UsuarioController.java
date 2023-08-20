package com.grupo16.techchallenge.usuario.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.techchallenge.usuario.controller.json.UsuarioJson;
import com.grupo16.techchallenge.usuario.domain.Usuario;
import com.grupo16.techchallenge.usuario.usecase.CriarAlterarUsuarioUseCase;
import com.grupo16.techchallenge.usuario.usecase.ObterUsuarioUseCase;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/usuarios")
@RestController
public class UsuarioController {

	@Autowired
	private CriarAlterarUsuarioUseCase criarAlterarUsuarioUseCase;

	@Autowired
	private ObterUsuarioUseCase obterUsuarioUseCase;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Long criar(
			@Valid 
			@RequestBody UsuarioJson usuarioJson) {
		log.trace("Start usuarioJson={}", usuarioJson);

		Usuario usuario = usuarioJson.mapearParaUsuarioDomain();

		Long usuarioId = criarAlterarUsuarioUseCase.criar(usuario);

		log.trace("End usuarioId={}", usuarioId);
		return usuarioId;
	}

	@GetMapping("{cpf}")
	public UsuarioJson obter(
			@PathVariable(name = "cpf", required = true) String cpf) {
		log.trace("Start cpf={}", cpf);

		String cpfUsuario = removeMask(cpf);
		
		Usuario usuario = obterUsuarioUseCase.obterByCpf(cpfUsuario);
		UsuarioJson usuarioJson = new UsuarioJson(usuario);
			
		log.trace("End usuarioJson={}", usuarioJson);
		return usuarioJson;
	}
	
	@PatchMapping
	public void alterar(
			@RequestBody(required = true) UsuarioJson usuarioJson) {
		log.trace("Start usuarioJson={}", usuarioJson);
		
		//TODO: implementar
		
		log.trace("End");
		
	}
	
	@DeleteMapping("{id}")
	public void remover(
			@PathVariable(name = "id", required = true) Long id) {
		log.trace("Start id={}", id);

		//TODO: implementar
		
		log.trace("End usuario={}");		
	}
	
	@GetMapping
	public List<UsuarioJson> buscar(
			@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "cpf", required = false) String cpf,
			@RequestParam(name = "parentesco", required = false) String parentesco,
			@RequestParam(name = "dataNascimento", required = false) LocalDate dataNascimento,
			@RequestParam(name = "genero", required = false) String genero){
		
		/*
		 * TODO implementar
		 * A busca deve ser capaz de filtrar as informações por nome, parentesco, 
		 * sexo ou outra informação relevante.
		 */
		
		return null;
	}
	
	private String removeMask(String cpf) {
		return cpf.replace(".", "").replace("-", "").replace(" ", "");
	}
}
