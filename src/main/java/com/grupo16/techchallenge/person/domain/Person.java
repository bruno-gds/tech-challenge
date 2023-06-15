package com.grupo16.techchallenge.person.domain;

import java.time.LocalDate;
import java.util.List;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode(of = {"cpf"})
public class Person {
	
	@Setter //TODO remover assim que estiver usando banco de dados para salvar.
	private Long id;

	private String name;
	private String cpf;
	private LocalDate birthDate;
	private String gender;	
	private List<Relative> relatives;
	
	public boolean exist(String cpf) {
		return this.cpf.equals(cpf);
	}

}
