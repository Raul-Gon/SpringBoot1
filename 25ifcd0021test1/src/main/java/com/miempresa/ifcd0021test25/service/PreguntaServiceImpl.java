package com.miempresa.ifcd0021test25.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miempresa.ifcd0021test25.entity.Dificultad;
import com.miempresa.ifcd0021test25.entity.Pregunta;
import com.miempresa.ifcd0021test25.repository.IPreguntaRepository;

@Service
public class PreguntaServiceImpl implements IPreguntaService {
	
	@Autowired
	private IPreguntaRepository preguntaRepository;
	
	@Override
	public Pregunta preguntaPorId(Long id) {
		return preguntaRepository.findById(id).orElse(null);
	}

	@Override
	public List<Pregunta> todasLasPreguntas() {
		return preguntaRepository.findAll();
	}
	
	@Override
	public void borraPregunta(Long id) {
		preguntaRepository.deleteById(id);
	}
	
	@Override
	public Pregunta savePregunta(Pregunta pregunta) {
		return preguntaRepository.saveAndFlush(pregunta);
	}
	
	@Override
	public List<Pregunta> todasLasPreguntasPorDificultad(Dificultad dificultad) {
		return preguntaRepository.findByDificultad(dificultad);
	}
	
	@Override
	public List<Pregunta> todasLasPreguntasPorTema(String tema) {
		return preguntaRepository.findByTema(tema);
	}
	
	
}
