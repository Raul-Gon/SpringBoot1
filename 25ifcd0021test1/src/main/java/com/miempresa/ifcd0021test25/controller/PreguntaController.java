package com.miempresa.ifcd0021test25.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.miempresa.ifcd0021test25.entity.Dificultad;
import com.miempresa.ifcd0021test25.entity.Pregunta;
import com.miempresa.ifcd0021test25.service.IPreguntaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/pregunta")
public class PreguntaController {
	
	@Autowired
	IPreguntaService preguntaService;
	
	@GetMapping("/id/{id}")
	public String m(Model model, @PathVariable Long id) {
		model.addAttribute("titulo", "Preguntas");
		model.addAttribute("h1", "Información sobre una pregunta");
		model.addAttribute("pregunta", preguntaService.preguntaPorId(id));
		return "pregunta/una-pregunta";
	}
	
	@GetMapping("/todas")
	public String todasLasPreguntas(Model model) {
		model.addAttribute("titulo", "Preguntas");
		model.addAttribute("h1", "Listado de preguntas");
		model.addAttribute("preguntas", preguntaService.todasLasPreguntas());
		return "pregunta/lista-preguntas";
	}
	
	@GetMapping("/dificultad/{dificultad}")
	public String todasLasPreguntasPorDificultad(Model model, 
			@PathVariable Dificultad dificultad) {
		model.addAttribute("titulo", "Preguntas");
		model.addAttribute("h1", "Listado de preguntas de dificultad " + dificultad.toString().toLowerCase());
		model.addAttribute("preguntas", preguntaService.todasLasPreguntasPorDificultad(dificultad));
		return "pregunta/lista-preguntas";
	}
	
	@GetMapping("/tema/{tema}")
	public String todasLasPreguntasPorTema(Model model, 
			@PathVariable String tema) {
		model.addAttribute("titulo", "Preguntas");
		model.addAttribute("h1", "Listado de preguntas de tema " + tema.toLowerCase());
		model.addAttribute("preguntas", preguntaService.todasLasPreguntasPorTema(tema));
		return "pregunta/lista-preguntas";
	}
	
	@GetMapping("/borra/id/{id}")
	public String borraPorId(Model model, RedirectAttributes flash,  @PathVariable Long id) {
		model.addAttribute("titulo", "Preguntas");
		model.addAttribute("h1", "Listado de preguntas");
		preguntaService.borraPregunta(id);
		flash.addFlashAttribute("warning", "Pregunta borrada con éxito");
		return "redirect:/pregunta/todas";
	}
	
	@GetMapping("/form/id/{id}")
	public String formParaPreguntaPorId(Model model, @PathVariable Long id) {
		model.addAttribute("titulo", "Preguntas");
		model.addAttribute("h1", "Formulario de preguntas");
		Pregunta pregunta = preguntaService.preguntaPorId(id) == null ? new Pregunta(): preguntaService.preguntaPorId(id);
		model.addAttribute("pregunta", pregunta);
		return "pregunta/form";
	}
	
	@PostMapping("/form")
	public String postParaActualizarPregunta(Model model, 
			RedirectAttributes flash, 
			@Valid Pregunta pregunta, 
			BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Preguntas");
			model.addAttribute("h1", "Formulario de preguntas");
			model.addAttribute("pregunta", pregunta);
			return "pregunta/form";
		}
		
		preguntaService.savePregunta(pregunta);
		flash.addFlashAttribute("success", "Pregunta añadida con éxito");
		return "redirect:/pregunta/todas";
	}
	
	@ResponseBody
	@GetMapping("/rest-todas")
	public List<Pregunta> listarRest(){
			return preguntaService.todasLasPreguntas();
	}
	
	@ResponseBody
	@GetMapping("/rest-id/{id}")
	public Pregunta m(@PathVariable Long id) {
		return preguntaService.preguntaPorId(id);
	}
	
}
