package com.example.baner.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Alumnos")
public class Alumno {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int matricula;
	
	@Column(name="nombre",length=50)
	private String nombre;
	
   
	 @ManyToMany(mappedBy="ListAlumno")
	 private Set<Curso> Toma_alumno;

	 

	public Set<Curso> getToma_alumno() {
		return Toma_alumno;
	}

	public void setToma_alumno(Set<Curso> toma_alumno) {
		Toma_alumno = toma_alumno;
	}

	@OneToOne
	@JoinColumn(name="id_expediente")
	private Expediente expediente;

	

	public Expediente getExpediente() {
		return expediente;
	}


	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
