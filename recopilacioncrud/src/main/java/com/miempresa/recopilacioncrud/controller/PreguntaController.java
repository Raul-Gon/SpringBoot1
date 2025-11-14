package com.miempresa.recopilacioncrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/examen")
public class PreguntaController {
	
	@ModelAttribute(name = "titulo")
	public String titulo() {
		return "EXAMEN";
	}
	
	@GetMapping({"/", "", "/home"})
	public String m(Model model) {
		model.addAttribute("cabecera", "Home del Examen.");
		return ("home");
	}

}
