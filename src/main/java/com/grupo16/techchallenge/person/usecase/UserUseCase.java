package com.grupo16.techchallenge.person.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.person.domain.User;
import com.grupo16.techchallenge.person.gateway.PersonRepositoryGateway;
import com.grupo16.techchallenge.person.usecase.exception.CpfAlreadyRegisteredException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserUseCase {
	
	@Autowired
	private PersonRepositoryGateway personRepository;

	public Long create(User user) {
		log.trace("Start user={}", user);
		
		Optional<User> userOp = personRepository.getByCpf(user.getCpf());
		if(userOp.isPresent()) {
			log.warn("CPF já cadastrado: {}", user.getCpf());
			throw new CpfAlreadyRegisteredException();
		}
		
		Long userId = personRepository.create(user);
		
		log.trace("End userId={}", userId);
		return userId;
	}
}
