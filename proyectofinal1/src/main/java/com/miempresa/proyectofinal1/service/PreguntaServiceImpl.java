package com.miempresa.proyectofinal1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miempresa.proyectofinal1.entity.Pregunta;
import com.miempresa.proyectofinal1.repository.IPreguntaRepository;

@Service("preguntaEnProduccion")
public class PreguntaServiceImpl implements IPreguntaService {

	@Autowired
	private IPreguntaRepository preguntaRepository;
	
	@Override
	public List<Pregunta> dameTodas(){
		return preguntaRepository.findAll();
	}

	@Override
	public Pregunta preguntaPorId(Long id) {
		return preguntaRepository.findById(id).orElse(null);
	}

	@Override
	public void borraPorId(Long id) {
		preguntaRepository.deleteById(id);		
	}

	@Override
	public void addPregunta(Pregunta pregunta) {
		preguntaRepository.saveAndFlush(pregunta);
	}
	
}
