package com.miempresa.ifcd0021test25.service;

import java.util.List;

import com.miempresa.ifcd0021test25.entity.Dificultad;
import com.miempresa.ifcd0021test25.entity.Pregunta;

public interface IPreguntaService {
	Pregunta preguntaPorId(Long id);
	List<Pregunta> todasLasPreguntas();
	void borraPregunta(Long id);
	Pregunta savePregunta(Pregunta pregunta);
	List<Pregunta> todasLasPreguntasPorDificultad(Dificultad dificultad);
	List<Pregunta> todasLasPreguntasPorTema(String tema);
		
	
	}
