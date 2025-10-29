package com.miempresa.segundoproyecto.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dado")
public class DadoController {
	
	public int dadoAleatorio() {
		Random random = new Random();
		return random.nextInt(1, 7);
	}
	
	@GetMapping("/null")
	public String d1(Model model) {
		model.addAttribute("titulo", "Dados");
		model.addAttribute("cabecera", "Lanzando un dado al azar");
		model.addAttribute("lanzamientos", null);
		return "/dado/mostrar-lanzamientos";
	}
	
	@GetMapping({"/cero", "/0"})
	public String d2(Model model) {
		model.addAttribute("titulo", "Dados");
		model.addAttribute("cabecera", "Lanzando un dado al azar");
		int [] arrayLanzamientos = {};
		model.addAttribute("lanzamientos", arrayLanzamientos);
		return "/dado/mostrar-lanzamientos";
	}
	
	@GetMapping({"/uno", "/1"})
	public String d3(Model model) {
		model.addAttribute("titulo", "Dados");
		model.addAttribute("cabecera", "Lanzando un dado al azar");
		int [] arrayLanzamientos = {dadoAleatorio()};
		model.addAttribute("lanzamientos", arrayLanzamientos);
		return "/dado/mostrar-lanzamientos";
	}
	
	@GetMapping({"/dos", "/2"})
	public String d4(Model model) {
		model.addAttribute("titulo", "Dados");
		model.addAttribute("cabecera", "Lanzando un dado al azar");
		int [] arrayLanzamientos = {dadoAleatorio(), dadoAleatorio()};
		model.addAttribute("lanzamientos", arrayLanzamientos);
		return "/dado/mostrar-lanzamientos";
	}

}
