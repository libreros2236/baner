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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Curso")
public class Curso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true)
	private int RFC;
	
	@Column(name="nombre")
	private String nombre;

	@OneToMany(mappedBy = "curso")
	private List<Profesor> profesor;
	
	@OneToOne
	@JoinColumn(name="Calificacion")
	private Calificacion calificacion;
	
	@ManyToMany
	@JoinTable(name = "Curso_alumno", 
    joinColumns =  @JoinColumn(name = "fk_Alumno") , 
    inverseJoinColumns =  @JoinColumn(name = "fk_Curso"))
	private Set<Alumno> ListAlumno;
	
	public Set<Alumno> getListAlumno() {
		return ListAlumno;
	}

	public void setListAlumno(Set<Alumno> listAlumno) {
		ListAlumno = listAlumno;
	}


	public Calificacion getCalificacion() {
		return calificacion;
	}


	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}


	public int getRFC() {
		return RFC;
	}

	public void setRFC(int rFC) {
		RFC = rFC;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Profesor> getProfesor() {
		return profesor;
	}

	public void setProfesor(List<Profesor> profesor) {
		this.profesor = profesor;
	}

	

	
}
