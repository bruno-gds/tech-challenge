package com.grupo16.techchallenge.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.techchallenge.person.controller.json.UserJson;
import com.grupo16.techchallenge.person.domain.User;
import com.grupo16.techchallenge.person.usecase.UserUseCase;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/users")
@RestController
public class UserController {
	
	@Autowired
	private UserUseCase personUseCase;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Long create(
			@Valid @RequestBody UserJson userJson) {
		log.trace("Start userJson={}", userJson);
		
		User user = userJson.toUser();
		
		Long userId = personUseCase.create(user);

		log.trace("End userId={}", userId);
		return userId;
	}
}
