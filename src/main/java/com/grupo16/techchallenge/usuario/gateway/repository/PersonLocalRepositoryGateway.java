package com.grupo16.techchallenge.usuario.gateway.repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.grupo16.techchallenge.usuario.domain.Usuario;
import com.grupo16.techchallenge.usuario.gateway.UserRepositoryGateway;
import com.grupo16.techchallenge.usuario.gateway.exception.ErrorToAccessDatabaseException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class PersonLocalRepositoryGateway implements UserRepositoryGateway {
	private Long sequenceId = 1L;
	
	Set<Usuario> people;

	public PersonLocalRepositoryGateway() {
		this.people = new HashSet<>();
	}

	@Override
	public Long create(Usuario person) {
		try {
			log.trace("Start person={}", person);
			person.setId(sequenceId++);
			
			people.add(person);
			
			Long personId = person.getId();
			
			log.trace("End personId={}", personId);
			return personId;
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErrorToAccessDatabaseException();
		}		
	}

	@Override
	public Optional<Usuario> getByCpf(String cpf) {
		try {
			return people.stream().filter(p -> p.getCpf().equals(cpf)).findFirst();

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErrorToAccessDatabaseException();
		}
		
	}

}
