package com.miempresa.proyectospring_thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miempresa.proyectospring_thymeleaf.service.ILocalService;

@Controller
@RequestMapping("/local")
public class LocalController {
	
	@Autowired	
	ILocalService localService;
	
	@ModelAttribute(name = "titulo")
	public String titulo() {
		return "LOCALES-COMERCIALES";
	}
	
	@GetMapping({"/", "/home", ""})
	public String inicio(Model model) {
		model.addAttribute("h1", "Locales Comerciales");
		return "home";
	}
	
	@GetMapping("/id/{id}")
	public String localPorId(@PathVariable Long id, Model model) {
		model.addAttribute("h2", "El local con id: "+ id);
		model.addAttribute("local", localService.localPorId(id));
		return "local/un-local";
	}
	
	@GetMapping("/todos")
	public String todosLosLocales(Model model) {
		model.addAttribute("h2", "Listado de todos los locales comerciales:");
		model.addAttribute("locales", localService.todosLosLocales());
		return "local/lista-locales";		
	}
	
	@GetMapping("/nombre/{nombre}")
	public String todasLasPreguntasPorDificultad(Model model, @PathVariable String nombre) {
		model.addAttribute("h2", "Local filtrado por el nombre: " + nombre.toString().toUpperCase());
		model.addAttribute("local", localService.localPorNombre(nombre));
		return "local/un-local";
	}
	
}
