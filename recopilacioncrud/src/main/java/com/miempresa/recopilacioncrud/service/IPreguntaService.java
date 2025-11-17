package com.miempresa.recopilacioncrud.service;

import java.util.List;

import com.miempresa.recopilacioncrud.entity.Pregunta;

public interface IPreguntaService {
	List<Pregunta> dameTodos();
	Pregunta preguntaPorId(Long id);
	void borraPorId(Long id);
	Pregunta addPregunta(Pregunta pregunta);
}
