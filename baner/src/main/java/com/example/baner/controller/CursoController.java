package com.example.baner.controller;

import java.util.List;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.baner.model.Alumno;
import com.example.baner.model.Calificacion;
import com.example.baner.model.Curso;
import com.example.baner.model.Expediente;
import com.example.baner.model.Profesor;
import com.example.baner.repository.AlumnoRepository;
import com.example.baner.repository.CalificacionRepository;
import com.example.baner.repository.CursoRepository;
import com.example.baner.repository.ProfesorRepository;

@RestController
public class CursoController {
	
	@Autowired
	private CursoRepository cursorepository;
	@Autowired
	private CalificacionRepository calificacionrepository;
	@Autowired
	private ProfesorRepository profesorrepository;
	
	@Autowired
	private AlumnoRepository alumnorepository;
	
	@PostMapping("/AgregaCurso")
	public Curso CreaCurso(@Valid @RequestBody Curso curso,Calificacion calificacion) {
		curso.setCalificacion(calificacion);
		calificacion.setCurso(curso);
		calificacionrepository.save(calificacion);
		return cursorepository.save(curso);
	}
	
	@GetMapping("/Cursos/{id}")
	public Curso ObtenAlumnoMat(@PathVariable(value="id") int RFC){
		Curso no=null;
		try {
			no=cursorepository.findById(RFC).get();
		}catch(Exception e) {			
		}
		return no;
	}

	@PostMapping("/CursoAltaAlumno/{idC}/{idA}")
	public void ActualizaAlumno(@PathVariable(value="idC")int Curso,@PathVariable(value="idA")int matricula){
		
		Curso m=cursorepository.findById(Curso).get();
		Alumno m1=alumnorepository.findById(matricula).get();
		
		m.getListAlumno().add(m1);
		m1.getToma_alumno().add(m);
		cursorepository.save(m);
		alumnorepository.save(m1);
	}
	
	@PostMapping("/CursoAltaProfe/{idC}/{idA}")
	public void ActualizaProfe(@PathVariable(value="idC")int Curso,@PathVariable(value="idA")int matricula){
		
		Curso m=cursorepository.findById(Curso).get();
		Profesor m1=profesorrepository.findById(matricula).get();
		m.getProfesor().add(m1);
		m1.setCurso(m);
		cursorepository.save(m);
		profesorrepository.save(m1);
	}
	
	@PutMapping("/CursoCC/{id}/{cali}")
	public void ActualizaCali(@PathVariable(value="id")int Curso,@PathVariable(value="cali")float cali){
		Curso m=cursorepository.findById(Curso).get();
		m.getCalificacion().setCalifi(cali);
		calificacionrepository.save(m.getCalificacion());
		cursorepository.save(m);
	}
	
	/*@PutMapping("/ProfeCC/{idc}/{idPC}/{idPP}")
	public void ActualizaPro(@PathVariable(value="idc")int Curso,@PathVariable(value="idPC")int matriculaC,@PathVariable(value="idPP")int matriculaP){
		Curso m=cursorepository.findById(Curso).get();
		Profesor m1=profesorrepository.findById(matriculaC).get();
		Profesor m2=profesorrepository.findById(matriculaP).get();
		m1.setCurso(null);
		m2.setCurso(m);
		m.getProfesor().;
		
		cursorepository.save(m);
	}*/
	
	/*@PostMapping("/AgregaCalificacoin/{idA}/{cali}")
	public void ActualizaCurso(@PathVariable(value="idA")int Curso,@Valid @RequestBody Calificacion calificacion){
		Curso m1=cursorepository.findById(Curso).get();
		m1.setCalificacion(calificacion);
		cursorepository.save(m1);
		calificacionrepository.save(calificacion);
	}*/
	
	
}
