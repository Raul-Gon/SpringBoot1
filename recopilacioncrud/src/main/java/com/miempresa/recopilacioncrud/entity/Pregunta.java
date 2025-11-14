package com.miempresa.recopilacioncrud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="preguntas")
public class Pregunta {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String tema;
	private Integer dificultad;
	private String enuncioado;
	private boolean solucion;
	
	public Pregunta() {
	}

	public Pregunta(String tema, Integer dificultad, String enuncioado, boolean solucion) {
		this.tema = tema;
		this.dificultad = dificultad;
		this.enuncioado = enuncioado;
		this.solucion = solucion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Integer getDificultad() {
		return dificultad;
	}

	public void setDificultad(Integer dificultad) {
		this.dificultad = dificultad;
	}

	public String getEnuncioado() {
		return enuncioado;
	}

	public void setEnuncioado(String enuncioado) {
		this.enuncioado = enuncioado;
	}

	public boolean isSolucion() {
		return solucion;
	}

	public void setSolucion(boolean solucion) {
		this.solucion = solucion;
	}	

}
