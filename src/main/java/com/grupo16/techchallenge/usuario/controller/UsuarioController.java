package com.grupo16.techchallenge.usuario.controller;

import java.time.LocalDate;
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

import com.grupo16.techchallenge.usuario.controller.json.UsuarioJson;
import com.grupo16.techchallenge.usuario.domain.Genero;
import com.grupo16.techchallenge.usuario.domain.TipoParentesco;
import com.grupo16.techchallenge.usuario.domain.Usuario;
import com.grupo16.techchallenge.usuario.dto.PesquisarUsuarioParamsDto;
import com.grupo16.techchallenge.usuario.usecase.CriarAlterarUsuarioUseCase;
import com.grupo16.techchallenge.usuario.usecase.ObterUsuarioUseCase;
import com.grupo16.techchallenge.usuario.usecase.RemoverUsuarioUseCase;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("usuarios")
@RestController
public class UsuarioController {

	@Autowired
	private CriarAlterarUsuarioUseCase criarAlterarUsuarioUseCase;

	@Autowired
	private ObterUsuarioUseCase obterUsuarioUseCase;

	@Autowired
	private RemoverUsuarioUseCase removerUsuarioUseCase;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Long criar(
			@Valid 
			@RequestBody UsuarioJson usuarioJson) {
		log.trace("Start usuarioJson={}", usuarioJson);

		Usuario usuario = usuarioJson.mapearParaUsuarioDomain(null);

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
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("{id}")
	public void alterar(
			@PathVariable(name = "id", required = true) Long id, 
			@Valid @RequestBody(required = true) UsuarioJson usuarioJson) {
		log.trace("Start usuarioJson={}", usuarioJson);
		
		Usuario usuario;
		if(usuarioJson.getParentesco() == null) {
			usuario = usuarioJson.mapearParaUsuarioDomain(id);
		}
		else {
			usuario = usuarioJson.mapearParaParenteDomain(id);
		}
		
		criarAlterarUsuarioUseCase.alterar(usuario);
		
		log.trace("End");
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	public void remover(
			@PathVariable(name = "id", required = true) Long id) {
		log.trace("Start id={}", id);

		removerUsuarioUseCase.remover(id);
		
		log.trace("End usuario={}");		
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("parentes")
	public Long criarParentesco(@Valid @RequestBody(required = true) UsuarioJson usuarioJson) {
		log.trace("Start usuarioJson={}", usuarioJson);
		
		Long parenteId = criarAlterarUsuarioUseCase.criar(usuarioJson.mapearParaParenteDomain(null));
		
		log.trace("End parenteId={}", parenteId);		
		return parenteId;
	}
	
	@GetMapping("{idUsuarioPrincipal}/parentes")
	public List<UsuarioJson> pesquisar(
			@PathVariable(name = "idUsuarioPrincipal", required = true) Long idUsuarioPrincipal,
			@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "cpf", required = false) String cpf,
			@RequestParam(name = "parentesco", required = false) String parentesco,
			@RequestParam(name = "dataNascimento", required = false) LocalDate dataNascimento,
			@RequestParam(name = "genero", required = false) String genero){
		log.trace("Start idUsuarioPrincipal={}, nome={}, cpf={}, parentesco={}, dataNascimento={}, genero={}",
				idUsuarioPrincipal, nome, cpf, parentesco, dataNascimento, genero);
		
		PesquisarUsuarioParamsDto paramsDto = PesquisarUsuarioParamsDto.builder()
				.idUsuarioPrincipal(idUsuarioPrincipal)
				.nome(nome)
				.cpf(cpf)
				.parentesco(parentesco == null ? null : TipoParentesco.valueOf(parentesco))
				.dataNascimento(dataNascimento)
				.genero(genero == null ? null : Genero.valueOf(genero))
				.build(); 
		
		List<Usuario> usuarios = obterUsuarioUseCase.pesquisar(paramsDto);
		
		List<UsuarioJson> usuariosJson = usuarios.stream().map(UsuarioJson::new).toList();
		
		log.trace("End usuariosJson={}", usuariosJson);
		return usuariosJson;
	}
	
	private String removeMask(String cpf) {
		return cpf.replace(".", "").replace("-", "").replace(" ", "");
	}
}
