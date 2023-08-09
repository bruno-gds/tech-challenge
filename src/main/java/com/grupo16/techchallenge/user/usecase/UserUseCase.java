package com.grupo16.techchallenge.user.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo16.techchallenge.user.domain.User;
import com.grupo16.techchallenge.user.gateway.UserRepositoryGateway;
import com.grupo16.techchallenge.user.usecase.exception.CpfAlreadyRegisteredException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserUseCase {
	
	@Autowired
	private UserRepositoryGateway userRepository;

	public Long create(User user) {
		log.trace("Start user={}", user);
		
		Optional<User> userOp = userRepository.getByCpf(user.getCpf());
		if(userOp.isPresent()) {
			log.warn("CPF já cadastrado: {}", user.getCpf());
			throw new CpfAlreadyRegisteredException();
		}
		
		Long userId = userRepository.create(user);
		
		log.trace("End userId={}", userId);
		return userId;
	}
}
