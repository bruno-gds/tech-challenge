package com.grupo16.techchallenge.user.controller.json;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.grupo16.techchallenge.user.domain.Parentesco;
import com.grupo16.techchallenge.user.domain.Usuario;
import com.grupo16.techchallenge.user.domain.Genero;

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
	
	public Usuario toUser() {
		List<Parentesco> relatedUsers = new ArrayList<>();
		if(relatives != null) {
			relatedUsers = relatives.stream().map(r -> r.toRelatedUser()).toList();
		}
		
		return Usuario.builder()
				.nome(name)
				.cpf(removeMask(cpf))
				.dataNascimento(birthDate)
				.genero(Genero.valueOf(gender))
				.parentes(relatedUsers)
				.build();
		
	}
	
	private String removeMask(String cpf) {
		return cpf.replace(".", "").replace("-", "").replace(" ", "");
	}
}
