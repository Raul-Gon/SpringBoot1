package com.miempresa.ejerciciopractico1corregido.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loto")
public class LotoController {
	
	@ModelAttribute(name = "titulo")
	public String titulo() {
		return "LOTO";
	}
	
	@GetMapping("/menu")
	public String menuHandler(Model model) {
		model.addAttribute("cabecera", "Menu de las diferentes LOTOS:");
		return "loto/menu";
	}
	
	private int[] sortea(int totalBolas, int numBolas) {
		List<Integer> bombo = new ArrayList<>();
		for(int i = 1; i <= totalBolas; i++) {
			bombo.add(i);
		}
		
		int[] sorteoGanador = new int[numBolas];
		Collections.shuffle(bombo);
		
		for(int i = 0; i < sorteoGanador.length; i++) {
			sorteoGanador[i] = bombo.get(i);
		}
		Arrays.sort(sorteoGanador);
		
		return sorteoGanador;
	}
	
	@GetMapping("/genera/{totalBolas}/{numBolas}/{pais}")
	public String sorteoHandler(Model model, @PathVariable int totalBolas, @PathVariable int numBolas, @PathVariable String pais) {		
		model.addAttribute("cabecera", "Sorteo de la loto: " + pais);		
		model.addAttribute("sorteo",  sortea(totalBolas, numBolas));
		
		return "loto/sorteo";
	}

}
