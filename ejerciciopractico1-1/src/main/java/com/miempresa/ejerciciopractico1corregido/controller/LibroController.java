package com.miempresa.ejerciciopractico1corregido.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miempresa.ejerciciopractico1corregido.model.Libro;

@Controller
@RequestMapping("/libro")
public class LibroController {
	
	@ModelAttribute(name = "titulo")
	public String titulo() {
		return "LIBROS";
	}
	
	@GetMapping("/menu")
	public String listaLibros(Model model) {
		model.addAttribute("cabecera", "Listado de libros:");
		model.addAttribute("libros", Libro.getBiblioteca());
		return "libro/listado";
	}
	
	@GetMapping("/id/{id}")
	public String listaLibros(Model model, @PathVariable int id) {
		model.addAttribute("cabecera", "Datos de un libro de la biblioteca: ");
		model.addAttribute("libro", Libro.getLibroById(id));
		return "libro/un-libro";
	}

}
