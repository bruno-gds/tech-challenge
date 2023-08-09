package com.grupo16.techchallenge.person.controller.json;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.grupo16.techchallenge.person.domain.User;
import com.grupo16.techchallenge.person.domain.RelatedUser;
import com.grupo16.techchallenge.person.domain.UserGender;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserJson {
	
	@NotBlank
	private String name;
	
	@NotNull
	@CPF
	private String cpf;
	
	@Past
	private LocalDate birthDate;

	@NotBlank
	private String gender;
	private List<RelatedUserJson> relatives;
	
	public User toUser() {
		List<RelatedUser> relatedUsers = new ArrayList<>();
		if(relatives != null) {
			relatedUsers = relatives.stream().map(r -> r.toRelative()).toList();
		}
		
		return User.builder()
				.name(name)
				.cpf(removeMask(cpf))
				.birthDate(birthDate)
				.gender(UserGender.valueOf(gender))
				.relatedUsers(relatedUsers)
				.build();
		
	}
	
	private String removeMask(String cpf) {
		return cpf.replace(".", "").replace("-", "").replace(" ", "");
	}
}
