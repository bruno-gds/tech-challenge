package com.grupo16.techchallenge.person.controller.json;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.grupo16.techchallenge.person.domain.Person;
import com.grupo16.techchallenge.person.domain.Relative;

import lombok.Getter;

@Getter
public class PersonJson {
	
	private String name;
	private String cpf;
	private LocalDate birthDate;
	private String gender;
	private List<RelativeJson> relatives;
	
	public Person toPerson() {
		List<Relative> relativesDomain = new ArrayList<>();
		if(relatives != null) {
			relativesDomain = relatives.stream().map(r -> r.toRelative()).toList();
		}
		
		return Person.builder()
				.name(name)
				.cpf(cpf)
				.birthDate(birthDate)
				.gender(gender)
				.relatives(relativesDomain) 
				.build();
	}	
}
