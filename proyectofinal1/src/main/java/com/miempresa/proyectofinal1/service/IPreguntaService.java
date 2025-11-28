package com.miempresa.proyectofinal1.service;

import java.util.List;

import com.miempresa.proyectofinal1.entity.Pregunta;

public interface IPreguntaService {
	
	List<Pregunta> dameTodas();
	Pregunta preguntaPorId(Long id);
	void borraPorId(Long id);
	void addPregunta(Pregunta pregunta);

}
