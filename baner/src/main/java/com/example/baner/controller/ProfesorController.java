package com.example.baner.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.baner.model.Alumno;
import com.example.baner.model.Curso;
import com.example.baner.model.Profesor;
import com.example.baner.repository.ProfesorRepository;

@RestController
public class ProfesorController {
	
	@Autowired
	private ProfesorRepository profesorrepository;
	
	
	@PostMapping("/InscribirProfesor")
	public Profesor crearAlumno(@Valid @RequestBody Profesor profesor) {
		return profesorrepository.save(profesor);		
	}
	
	@DeleteMapping("/BajaProfesor/{id}")
	public void BorraAlumno(@PathVariable(value="id")int matricula) {
		Profesor n=profesorrepository.findById(matricula).get();
		profesorrepository.delete(n);		
	}
	
	@GetMapping("/Profesores/{id}")
	public Profesor ObtenAlumnoMat(@PathVariable(value="id") int matriculaProcesor){
		Profesor no=null;
		try {
			no=profesorrepository.findById(matriculaProcesor).get();
		}catch(Exception e) {			
		}
		return no;
	}

}
