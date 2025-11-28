package com.miempresa.ifcd0021test25.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miempresa.ifcd0021test25.entity.Pregunta;
import com.miempresa.ifcd0021test25.service.IPreguntaService;

@RestController
@RequestMapping("/api/pregunta")
public class PreguntaRestController {
	
	@Autowired
	IPreguntaService preguntaService;
	
	@GetMapping("/listar")
	public List<Pregunta> listarPreguntas(){
		return preguntaService.todasLasPreguntas();
	}
	
	@GetMapping("/listar/id/{id}")
	public Pregunta listarUnaPreguntaPorId(@PathVariable Long id) {
		return preguntaService.preguntaPorId(id);
	}
	
	@DeleteMapping("/borrar/{id}")
	public void borrarPreguntaPorId(@PathVariable Long id) {
		preguntaService.borraPregunta(id);
	}

	@PostMapping("/crear")
	public Pregunta crearPregunta(@RequestBody Pregunta pregunta) {
		if(pregunta.getId() == null) return preguntaService.savePregunta(pregunta);
		return null;
	}
	
	@PutMapping("/actualizar")
	public Pregunta actualizarPregunta(@RequestBody Pregunta pregunta) {
		if(pregunta.getId() != null && preguntaService.preguntaPorId(pregunta.getId()) != null) return preguntaService.savePregunta(pregunta);
		return null;
	}
	
}
