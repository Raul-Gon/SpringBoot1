package com.miempresa.recopilacioncrud.entity;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

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

	@NotEmpty
	private String tema;
	private int dificultad;
	@NotEmpty
	private String enunciado;
	@NotEmpty
	private boolean solucion;
	
	public Pregunta() {
	}

	public Pregunta(String tema, Integer dificultad, String enuncioado, boolean solucion) {
		this.tema = tema;
		this.dificultad = dificultad;
		this.enunciado = enuncioado;
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

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enuncioado) {
		this.enunciado = enuncioado;
	}

	public boolean isSolucion() {
		return solucion;
	}

	public void setSolucion(boolean solucion) {
		this.solucion = solucion;
	}	

}
