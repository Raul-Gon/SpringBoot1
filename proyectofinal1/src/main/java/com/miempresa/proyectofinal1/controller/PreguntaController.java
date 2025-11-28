package com.miempresa.proyectofinal1.controller;

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

import com.miempresa.proyectofinal1.service.IPreguntaService;

import jakarta.validation.Valid;

import com.miempresa.proyectofinal1.entity.Pregunta;

@Controller
@RequestMapping("/pregunta")
public class PreguntaController {

	@Autowired
	@Qualifier("preguntaEnProduccion")
	private IPreguntaService preguntaService;
	
	@ModelAttribute(name = "titulo")
	public String titulo() {
		return "EXAMEN-PREGUNTAS";
	}
	
	@GetMapping({"/", "", "/home"})
	public String menuPrincipal(Model model) {
		model.addAttribute("cabecera", "¡¡¡¡BIENVENIDOS AAAA!!!!");
		return "home/home";
	}
	
	@GetMapping("/todas")
	public String listadoPreguntas(Model model) {
		model.addAttribute("cabecera", "Listado de todas las preguntas");
		model.addAttribute("preguntas", preguntaService.dameTodas());
		return "pregunta/todas";
	}
	
	@GetMapping("/id/{id}")
	public String unaPreguntaPorId(Model model, @PathVariable Long id) {
		model.addAttribute("cabecera", "Datos de una pregunta");
		model.addAttribute("pregunta", preguntaService.preguntaPorId(id));
		return "pregunta/una";		
	}
	
	@GetMapping("/borrar/id/{id}")
	public String borrarById(@PathVariable Long id, RedirectAttributes flash) {	
		preguntaService.borraPorId(id);
		flash.addFlashAttribute("warning", "El campo se ha borrado satisfactoriamente.");
		return "redirect:/pregunta/todas";
	}
	
	@GetMapping("/form/{id}")
	public String formPreguntaGet(Model model, @PathVariable long id) {	
		Pregunta pregunta = id == -1 ? new Pregunta() : preguntaService.preguntaPorId(id);	
		model.addAttribute("cabecera", "Formulario de Pregunta:");
		model.addAttribute("pregunta", pregunta);	
		return "pregunta/form";
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
		return "redirect:/pregunta/todas";
	}
	
}
