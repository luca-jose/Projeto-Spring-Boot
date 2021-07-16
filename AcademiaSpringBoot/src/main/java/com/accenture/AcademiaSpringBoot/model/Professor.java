package com.accenture.AcademiaSpringBoot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professor {

	private String cpf;	
	private String name;
	private double salario;
	private int idade;
}
