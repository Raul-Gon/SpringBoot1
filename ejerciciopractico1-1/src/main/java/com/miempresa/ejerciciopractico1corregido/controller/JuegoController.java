package com.miempresa.ejerciciopractico1corregido.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miempresa.ejerciciopractico1corregido.model.Ciudad;
import com.miempresa.ejerciciopractico1corregido.model.Libro;

@Controller
@RequestMapping("/juego")
public class JuegoController {
	
	@ModelAttribute(name= "titulo")
	public String titulo() {
		return "JUEGO CIUDADES";
	}
	
	@GetMapping("/menu")
	public String menuJuegos(Model model) {
		model.addAttribute("cabecera", "Elige un número para ver si adivinas la ciudad:");
		return "juego/menu";
	}
	 
	@GetMapping("/una-ciudad")
	public String unaCiudad(Model model) {
		model.addAttribute("cabecera", "Adivina que ciudad es...");	
		model.addAttribute("ciudad", Ciudad.ciudadAleatoria());
		return "juego/una-ciudad";
	}
	
	@GetMapping("/validar-respuesta")
	public String validarRespuesta(Model model, @RequestParam String solucion, @RequestParam int id) {
		model.addAttribute("cabecera", "¿Has acertado?:");	
		if(Ciudad.validaRespuesta(id, solucion)) {
			model.addAttribute("respuesta", "Has acertado, la ciudad es " + solucion);
		}else {
			model.addAttribute("respuesta", "Has perdido, la ciudad no es " + solucion);			
		}
		
		return "juego/respuesta";
	}
	
}
