package com.miempresa.segundoproyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miempresa.segundoproyecto.model.Articulo;

@Controller
@RequestMapping("/articulo")
public class ArticuloController {

	/*
	private List<Articulo> listaArticulos = listaArticulos();
	
	private List<Articulo> listaArticulos(){
		
		return null;
	}
	*/
	
	//CON ESTE METODO LO QUE HACEMOS ES QUE CREAMOS UN ATRIBUTO QUE SIEMPRE SE VA A MANDAR POR MEDIO DE MODEL DE NOMBRE TITULO
	@ModelAttribute(name = "titulo")
	public String titulo() {
		return "Artículos";
	}
	
	@GetMapping("/uno")
	public String mostrarArticulo(Model model) {
		model.addAttribute("cabecera", "Mostrando un artículo");
		model.addAttribute("articulo", new Articulo("Guantes", 500, 20.25, "rojo"));
		return "articulo/muestra-articulos";
	}
	
	@GetMapping("/ninguno")
	public String mostrarNingunArticulo(Model model) {
		model.addAttribute("cabecera", "Mostrando ningun tipo artículo");
		model.addAttribute("articulo", null);		
		return "articulo/muestra-articulos";
	}
	
}
