package com.accenture.AcademiaSpringBoot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

	private String cpf;	
	private String name;
	private String curso;
	private int idade;
	
	
}
