package com.miempresa.segundoproyecto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miempresa.segundoproyecto.model.Animal;

@Controller
@RequestMapping("/animal")
public class AnimalController {
	
	//@Value("Animales")     SI LO QUISIERAMOS PASAR COMO 
	//private String titulo; PARAMETRO QUE SIEMPRE FUERA EL MISMO
	
	//CON ESTE METODO LO QUE HACEMOS ES QUE CREAMOS UN ATRIBUTO QUE SIEMPRE SE VA A MANDAR POR MEDIO DE MODEL DE NOMBRE TITULO
	@ModelAttribute(name = "titulo")
	public String titulo() {
		return "Animales";
	}
	
	private List<Animal> listaAnimales = listaAnimales();
	
	private List<Animal> listaAnimales() {
		List<Animal> animales = new ArrayList<>();
		animales.add(new Animal(130, 1230, "gato"));
		animales.add(new Animal(150, 123, "perro"));
		animales.add(new Animal(10, 1330, "gato"));
		animales.add(new Animal(1300, 30, "loro"));
		return animales;
	}
	
	@GetMapping({"/ungato", "/un-gato"})
	public String mostrarUnGato(Model model) {		
		//model.addAttribute("titulo", titulo); COMO NO LO VAMOS A PASAR POR MEDIO DE MODEL YA QUE LO ESTAMOS PASANDO CON EL METODO TITULO
		model.addAttribute("cabecera", "Mostrando un GATO");
		
		Animal miGato = new Animal(13, 1230, "gato");
		model.addAttribute("animal", miGato);
		
		return "animal/un-animal";
	}
	
	@GetMapping({"/ningungato", "ningun-gato"})
	public String mostrarNingunGato(Model model) {		
		//model.addAttribute("titulo", titulo);  COMO NO LO VAMOS A PASAR POR MEDIO DE MODEL YA QUE LO ESTAMOS PASANDO CON EL METODO TITULO
		model.addAttribute("cabecera", "Mostrando ningun GATO");
		
		model.addAttribute("animal", null);
		model.addAttribute("mensaje", "No hay ningún gato para mostrar su información.");
		
		return "animal/un-animal";
	}
	
	@GetMapping("/lista")
	public String mostrarLista(Model model) {
				
		model.addAttribute("cabecera", "Mostrando lista de animales");
		model.addAttribute("listaAnimales", listaAnimales);		
		return "animal/lista-animales";
	}
	
	@GetMapping("/lista-null")
	public String mostrarListaNull(Model model) {				
		model.addAttribute("mensaje", "No hay ningún ANIMAL para mostrar su información.");
		model.addAttribute("cabecera", "Mostrando lista de animales");
		model.addAttribute("listaAnimales", null);		
		return "animal/lista-animales";
	}
	
}
