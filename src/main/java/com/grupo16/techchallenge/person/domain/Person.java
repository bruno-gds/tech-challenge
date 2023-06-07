package com.grupo16.techchallenge.person.domain;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;

@Getter
public class Person {
	
	private String name;
	private String cpf;
	private LocalDate birthDate;
	private String gender;	
	private List<Relative> relatives;

}
