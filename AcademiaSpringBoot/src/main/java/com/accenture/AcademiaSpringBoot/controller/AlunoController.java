package com.accenture.AcademiaSpringBoot.controller;

import java.util.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.accenture.AcademiaSpringBoot.model.Aluno;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	private List<Aluno> alunos = new ArrayList<Aluno>();

	@PostMapping("/create")
	public String createAluno(@RequestBody Aluno aluno) {
		alunos.add(aluno);
		return "Aluno Cadastrado!";
	}
	
	@GetMapping("/view")
	public List<Aluno> viewAluno() {
		return alunos;
	}
	
	@GetMapping("/viewaluno/{cpf}")
    public Aluno viewAluno(@PathVariable("cpf") String cpf) {
    	Aluno procurado = null;
    	for(Aluno aluno: alunos) {
    		if(aluno.getCpf().equals(cpf)) 
    			procurado = aluno;
    	}
        return procurado;
	}
	@DeleteMapping("/delete/{cpf}")
	public  String deleteAluno(@PathVariable("cpf") String cpf) {
		Aluno procurado = null;
    	for(Aluno aluno: alunos) {
    		if(aluno.getCpf().equals(cpf)) 
    			procurado = aluno;		
		}
    	alunos.remove(procurado);
    	return "Aluno deletado!";
	}
	
	@PutMapping("/update/{cpf}")
	public String updateAluno(@RequestBody Aluno aluno, @PathVariable("cpf") String cpf) {
		Aluno update = null;
		for(int i = 0; i < alunos.size(); i++) {
			update = alunos.get(i);
			if(update.getCpf().equals(cpf))
				alunos.set(i,aluno);
		}
		return "Aluno Atualizado!";
	}
	
	
	
}