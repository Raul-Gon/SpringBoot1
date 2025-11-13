package com.miempresa.segundocrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping
	public String homePrincipal(Model model) {
		model.addAttribute("titulo", "HOME");
		model.addAttribute("cabecera", "HOME DE EDIFICIOS: Elige tu opción.");
		return "home";
	}
	

}
