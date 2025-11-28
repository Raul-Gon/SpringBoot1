package com.miempresa.ifcd0021test25.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miempresa.ifcd0021test25.service.IBolaDragonService;

@Controller
@RequestMapping("/boladragon")
public class BolaDragonController {
	
	@Autowired
	IBolaDragonService bolaDragonService;
	
	@ModelAttribute(name="titulo")
	public String titulo() {
		return "BOLA DE DRAGÓN";
	}
	
	@GetMapping("/nombre/{nombre}")
	public String unBolaDragon(@PathVariable String nombre, Model model) {
		model.addAttribute("cabecera", String.format("FICHA DE %s EN BOLA DE DRAGÓN Z:", nombre));
		model.addAttribute("bolaDragones", bolaDragonService.getBolaDragon(nombre));
		return "bola-dragon/una-ficha";
	}

}
