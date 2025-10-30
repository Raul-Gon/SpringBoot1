package com.miempresa.ejerciciopractico1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/loto", "/home/loto", "/loto"})
public class LotoController {

	@GetMapping("/menu")
	public String menu(Model model) {
		model.addAttribute("titulo", "PROYECTO1");
		model.addAttribute("cabecera", "Bienvenidos al MENÚ de LOTERÍAS:");
		return "loto/menu";
	}
	
	@GetMapping("/genera/{bolas}/{numeros}/{pais}")
	public String genera(Model model, @PathVariable int bolas, @PathVariable int numeros, @PathVariable String pais) {
		return "loto/genera";
	}
	
}
