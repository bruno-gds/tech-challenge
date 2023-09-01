package com.grupo16.techchallenge.usuario.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.usuario.domain.Parente;
import com.grupo16.techchallenge.usuario.domain.Usuario;
import com.grupo16.techchallenge.usuario.gateway.UsuarioRepositoryGateway;
import com.grupo16.techchallenge.usuario.usecase.exception.CpfJaCadastradoException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CriarAlterarUsuarioUseCase {
	
	@Autowired
	private UsuarioRepositoryGateway usuarioRepository;

	@Autowired
	private ObterUsuarioUseCase obterUsuarioUseCase;

	public Long criar(Usuario usuario) {
		log.trace("Start usuario={}", usuario);
		
		//TODO: adicionar nesta pesquisa o id do usuário principal para qd criar usuario parente (débito técnico).
		Optional<Usuario> usuarioOp = usuarioRepository.obterByCpf(usuario.getCpf());
		if(usuarioOp.isPresent()) {
			log.warn("CPF já cadastrado: {}", usuario.getCpf());
			throw new CpfJaCadastradoException();
		}
		
		Long usuarioId = usuarioRepository.salvar(usuario);
		
		log.trace("End usuarioId={}", usuarioId);
		return usuarioId;
	}

	public void alterar(Usuario usuario) {
		log.trace("Start usuario={}", usuario);

		Usuario usuarioEncontrado = obterUsuarioUseCase.obter(usuario.getId());
		
		if(usuarioEncontrado instanceof Parente) {
			Parente parenteEncontrado = (Parente) usuarioEncontrado;
			Parente parenteToUpdate = (Parente) usuario;
			Parente parenteToSave = Parente.builder()
					.id(parenteEncontrado.getId())
					.nome(parenteToUpdate.getNome())
					.cpf(parenteToUpdate.getCpf())
					.dataNascimento(parenteToUpdate.getDataNascimento())
					.genero(parenteToUpdate.getGenero())
					.parentesco(parenteToUpdate.getParentesco())
					.usuarioPrinpal(Usuario.builder()
							.id(parenteEncontrado.getUsuarioPrinpal().getId())
							.build())
					.build();
			usuarioRepository.salvar(parenteToSave);
			log.trace("End");
		}
		else {
			Usuario usuarioToSave = Usuario.builder()
					.id(usuarioEncontrado.getId())
					.nome(usuario.getNome())
					.cpf(usuario.getCpf())
					.dataNascimento(usuario.getDataNascimento())
					.genero(usuario.getGenero())
					.build();
			
			usuarioRepository.salvar(usuarioToSave);
			
			log.trace("End");
		}
	}
}
