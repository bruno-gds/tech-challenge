package com.grupo16.techchallenge.person.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.person.domain.Person;
import com.grupo16.techchallenge.person.gateway.PersonRepositoryGateway;
import com.grupo16.techchallenge.person.usecase.exception.CpfAlreadyRegisteredException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PersonUseCase {
	
	@Autowired
	private PersonRepositoryGateway personRepository;

	public Long create(Person person) {
		log.trace("Start person={}", person);
		
		Optional<Person> personOp = personRepository.getByCpf(person.getCpf());
		if(personOp.isPresent()) {
			log.warn("CPF já cadastrado: {}", person.getCpf());
			throw new CpfAlreadyRegisteredException();
		}
		
		Long personId = personRepository.create(person);
		
		log.trace("End personId={}", personId);
		return personId;
	}
}
