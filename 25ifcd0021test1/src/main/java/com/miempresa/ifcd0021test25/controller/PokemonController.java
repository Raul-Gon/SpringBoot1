package com.miempresa.ifcd0021test25.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miempresa.ifcd0021test25.service.IPokemonService;

@Controller
@RequestMapping("/pokemon")
public class PokemonController {

	@ModelAttribute(name="titulo")
	public String titulo() {
		return "POKEMONES";
	}
	
	@Autowired
	IPokemonService pokemonService;
	
	@GetMapping("/nombre/sin-imagen/{nombre}")
	public String unPokemonSinImagen(Model model, @PathVariable String nombre) {
		model.addAttribute("cabecera", String.format("Datos del pokemon %s sin imagenes", nombre));
		model.addAttribute("pokemon", pokemonService.getPokemonSimple(nombre));
		return "pokemon/sin-imagen";
	}
	
	@GetMapping("/nombre/con-imagen/{nombre}")
	public String unPokemonConImagen(@PathVariable String nombre, Model model) {
		model.addAttribute("cabecera", "NOMBRE E IMAGEN DEL POKEMON:");
		model.addAttribute("pokemon", pokemonService.getPokemonFull(nombre));
		return "pokemon/con-imagen";
	}
	
}
