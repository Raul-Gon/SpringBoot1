package com.miempresa.recopilacioncrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miempresa.recopilacioncrud.entity.Pregunta;
import com.miempresa.recopilacioncrud.repository.IPreguntaRepository;

@Service("preguntaEnProduccion")
public class PreguntaServiceImpl implements IPreguntaService {

	@Autowired
	IPreguntaRepository preguntaRepository;
	
	@Override
	public List<Pregunta> dameTodos() {
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
	public Pregunta addPregunta(Pregunta pregunta) {
		return preguntaRepository.save(pregunta);
	}

}
