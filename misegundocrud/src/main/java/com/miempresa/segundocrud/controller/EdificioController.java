package com.miempresa.segundocrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miempresa.segundocrud.entity.Edificio;
import com.miempresa.segundocrud.service.IEdificioService;

@Controller
@RequestMapping("/edificio")
public class EdificioController {
	
	@Autowired
	private IEdificioService edificioService; 

	@ModelAttribute("titulo")
	public String titulo() {
		return "EDIFICIO";
	}
	
	@GetMapping("/listado")
	public String m(Model model) {
		model.addAttribute("cabecera", "Listado de edificios:");
		List<Edificio> edificios = edificioService.muestraTodos();
		model.addAttribute("edificios", edificios);	
		return "edificio/edificios";
	}
	
}
