package com.miempresa.proyectospring_thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.miempresa.proyectospring_thymeleaf.entity.Local;
import com.miempresa.proyectospring_thymeleaf.service.ILocalService;

import jakarta.validation.Valid;

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
	
	@GetMapping("/borra/id/{id}")
	public String borraPorId(Model model, RedirectAttributes flash,  @PathVariable Long id) {
		model.addAttribute("h2", "Listado de Locaoles");
		localService.borrarLocal(id);
		flash.addFlashAttribute("warning", "Local borrado con éxito");
		return "redirect:/local/todos";
	}
	
	@GetMapping("/form/id/{id}")
	public String formParaPreguntaPorId(Model model, @PathVariable Long id) {
		model.addAttribute("h2", "Formulario de Locales");
		Local local = localService.localPorId(id) == null ? new Local(): localService.localPorId(id);
		model.addAttribute("local", local);
		return "local/form";
	}
	
	@PostMapping("/form")
	public String postParaActualizarPregunta(Model model, RedirectAttributes flash, @Valid Local local, BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("h2", "Formulario de Locales");
			model.addAttribute("local", local);
			return "local/form";
		}
		
		localService.guardarLocal(local);
		flash.addFlashAttribute("success", "Local añadido con éxito");
		return "redirect:/local/todos";
	}
	
}
