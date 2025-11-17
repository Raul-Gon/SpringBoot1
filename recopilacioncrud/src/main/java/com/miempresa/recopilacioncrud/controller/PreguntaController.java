package com.miempresa.recopilacioncrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.miempresa.recopilacioncrud.entity.Pregunta;
import com.miempresa.recopilacioncrud.service.PreguntaServiceImpl;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/examen")
public class PreguntaController {
	
	@Autowired
	@Qualifier("preguntaEnProduccion")
	PreguntaServiceImpl preguntaService;
	
	@ModelAttribute(name = "titulo")
	public String titulo() {
		return "EXAMEN";
	}
	
	@GetMapping({"/", "", "/home"})
	public String principal(Model model) {
		model.addAttribute("cabecera", "Home del Examen.");
		return ("home");
	}

	@GetMapping("/id/{id}")
	public String preguntaById(Model model, @PathVariable Long id) {
		model.addAttribute("cabecera", "Datos de la pregunta:");
		model.addAttribute("pregunta", preguntaService.preguntaPorId(id));		
		return "examen/una-pregunta";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrarById(@PathVariable Long id, RedirectAttributes flash) {	
		preguntaService.borraPorId(id);
		flash.addFlashAttribute("warning", "El campo se ha borrado satisfactoriamente.");
		return "redirect:/examen/preguntas";
	}
		
	@GetMapping("/form/{id}")
	public String formPreguntaGet(Model model, @PathVariable long id) {
		Pregunta pregunta = id == -1 ? new Pregunta() : preguntaService.preguntaPorId(id);		
		model.addAttribute("cabecera", "Formulario de Pregunta:");
		model.addAttribute("pregunta", pregunta);	
		return "examen/form";
	}
	
	@PostMapping("/form")
	public String formPreguntaPost(@Valid Pregunta pregunta, BindingResult result, RedirectAttributes flash, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("cabecera", "Formulario de Pregunta:");
			model.addAttribute("pregunta", pregunta);	
			return "examen/form";
		}		
		preguntaService.addPregunta(pregunta);		
		flash.addFlashAttribute("succes", "Pregunta guardada");
		return "redirect:/examen/preguntas";
	}
	
	@GetMapping("/preguntas")
	public String listadoPreguntas(Model model) {
		model.addAttribute("cabecera", "Listado de todas las PREGUNTAS:");
		model.addAttribute("preguntas", preguntaService.dameTodos());
		return "examen/listado";
	}
	
	@GetMapping("/cuestionario")
	public String formExamen(Model model) {
		model.addAttribute("cabecera", "Examen:");
		
		return "examen/cuestionario";
	}
	
}
