package com.example.baner.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.baner.model.Alumno;
import com.example.baner.model.Expediente;
import com.example.baner.repository.AlumnoRepository;
import com.example.baner.repository.ExpedienteRepository;

@RestController
public class AlumnoController {
	
	@Autowired
	private AlumnoRepository alumnorepository;
	
	@Autowired
	private ExpedienteRepository expedienterepository;
	
	@PostMapping("/InscribirAlumno")
	public Alumno crearAlumno(@Valid @RequestBody Alumno alumno,Expediente f) {
		alumno.setExpediente(f);
		f.setAlumno(alumno);
		expedienterepository.save(f);
		return alumnorepository.save(alumno);		
	}
	
	@DeleteMapping("/BajaAlumno/{id}")
	public void BorraAlumno(@PathVariable(value="id")int matricula) {
		Alumno n=alumnorepository.findById(matricula).get();
		alumnorepository.delete(n);		
	}
	
	@GetMapping("/Alumnos/{id}")
	public Alumno ObtenAlumnoMat(@PathVariable(value="id") int matricula){
		Alumno no=null;
		try {
			no=alumnorepository.findById(matricula).get();
			
		}catch(Exception e) {
			
		}
		return no;
	}
	
	@PutMapping("/AlumnoExpdiente/{id}")
	public Alumno ActualizaAlumno(@PathVariable(value="id") int matricula,@Valid @RequestBody Expediente expe){
			Alumno n=alumnorepository.findById(matricula).get();
			n.getExpediente().setDescripcion(expe.getDescripcion());
			expedienterepository.save(n.getExpediente());
	        return alumnorepository.save(n);
	}
	
	/*@PutMapping("/Alumno/{id}")
	public Alumno ActualizaAlumno(@PathVariable(value="id") int matricula,@Valid @RequestBody Alumno alumno){
			Alumno n=alumnorepository.findById(matricula).get();
			n.setExpediente(alumno.getExpediente());
			n.setNombre(alumno.getNombre());
	        return alumnorepository.save(n);
	}*/
	
	
}
