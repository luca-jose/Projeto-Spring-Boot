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
import com.accenture.AcademiaSpringBoot.model.Professor;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
	
	private List<Professor> professores = new ArrayList<Professor>();

	@PostMapping("/create")
	public String createProfessor(@RequestBody Professor professor) {
		professores.add(professor);
		return "Professor Cadastrado!";
	}
	
	@GetMapping("/view")
	public List<Professor> viewProfessor() {
		return professores;
	}
	
	@GetMapping("/viewprofessor/{cpf}")
    public Professor viewProfessor(@PathVariable("cpf") String cpf) {
    	Professor procurado = null;
    	for(Professor professor: professores) {
    		if(professor.getCpf().equals(cpf)) 
    			procurado = professor;
    	}
        return procurado;
	}
	@DeleteMapping("/delete/{cpf}")
	public  String deleteProfessor(@PathVariable("cpf") String cpf) {
		Professor procurado = null;
    	for(Professor professor: professores) {
    		if(professor.getCpf().equals(cpf)) 
    			procurado = professor;		
		}
    	professores.remove(procurado);
    	return "Professor deletado!";
	}
	
	@PutMapping("/update/{cpf}")
	public String updateProfessor(@RequestBody Professor professor, @PathVariable("cpf") String cpf) {
		Professor update = null;
		for(int i = 0; i < professores.size(); i++) {
			update = professores.get(i);
			if(update.getCpf().equals(cpf))
				professores.set(i,professor);
		}
		return "Professor Atualizado!";
	}
		
}