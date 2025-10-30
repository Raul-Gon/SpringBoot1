package com.miempresa.ejerciciopractico1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	private List<String> listaProverbios= listaProverbio();
	
	private List<String> listaProverbio() {
		List<String> listaProverbios = new ArrayList<>();
		listaProverbios.add("El silencio es una gran fuente de fortaleza");
		listaProverbios.add("Exígete mucho a ti mismo y espera poco de los demás");
		listaProverbios.add("Si me enseñas a pescar, comeré para siempre");
		listaProverbios.add("El jade necesita ser tallada para ser una gema");
		listaProverbios.add("Me lo contaron y lo olvidé, lo vi y lo entendí, lo hice y lo aprendí");
		listaProverbios.add("El que teme sufrir ya sufre el temor");
		listaProverbios.add("No dudes en perder la batalla si esto te lleva a ganar la guerra");
		listaProverbios.add("Si no quieres que se sepa, no lo hagas");
		listaProverbios.add("No hay manjar que no empalague, ni vicio que no enfade");
		listaProverbios.add("Antes de ser un dragón, hay que sufrir como una hormiga");	
				
		return listaProverbios;
	}	
	
	@GetMapping({"/", "/home", ""})
	public String m(Model model) {
		model.addAttribute("titulo", "PROYECTO1");
		model.addAttribute("cabecera", "Bienvenidos al MENÚ principal:");
		Random r = new Random();
		model.addAttribute("frase", listaProverbios.get(r.nextInt(0, listaProverbios.size())));
		
		return "home/home";
	}

}
