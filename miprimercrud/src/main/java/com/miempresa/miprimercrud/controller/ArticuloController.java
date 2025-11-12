package com.miempresa.miprimercrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miempresa.miprimercrud.entity.Articulo;
import com.miempresa.miprimercrud.service.IArticuloService;

@Controller //le decimos que es un controller
@RequestMapping("/articulo") //le damos el principio de nuestra ruta lo que es comun para todos nuestro endpoints http://localhost:8080/articulo/....
public class ArticuloController {
	
	@Autowired //inyección automática de dependencias; que proporcione automáticamente una instancia de una clase (la dependencia) en otra clase, sin que tengas que crearla manualmente con new 
	@Qualifier("articuloEnProduccion") //le dice que implementacion (IMPL) de la interfaz es la que tiene que aplicar
	private IArticuloService articuloService;
	
	@ModelAttribute("titulo") //creamos un atributo que siempre va a viajar con nuestro Model y su nombre es titulo y el contenido el que pongamos en el return
	public String titulo() {
		return "ARTICULOS";
	}
	
	@GetMapping("/id/{id}")
	public String articuloById(Model model, @PathVariable Long id) {
		model.addAttribute("cabecera", "Mostramos los datos del articulo:");
		model.addAttribute("articulo", articuloService.dameArticuloPorId(id));
		return "articulo/un-articulo";
	}

	@GetMapping("/todos")
	public String allArticulos(Model model) {
		model.addAttribute("cabecera", "Mostramos lista de articulos:");
		model.addAttribute("articulos", articuloService.dameTodosLosArticulos());		
		return "articulo/articulos";
	}
	
	@GetMapping("/tipo/{tipo}")
	public String articulosByTipo(Model model, @PathVariable String tipo) {
		model.addAttribute("cabecera", "Mostramos los datos de los articulos del tipo " + tipo);
		model.addAttribute("articulos", articuloService.dameArticulosPortipo(tipo));
		return "articulo/articulos";
	}
	
	@GetMapping("/borrar/id/{id}")
	public String borraArticuloById(@PathVariable long id) {
		articuloService.borrarUnArticulo(id);	
		return "redirect:/articulo/todos";
		
	}
	
	@GetMapping("/form/id/{id}")
	public String formArticuloGet(Model model, @PathVariable long id) {
		Articulo articulo = id == -1 ? new Articulo() : articuloService.dameArticuloPorId(id);		
		model.addAttribute("cabecera", "Formulario de articulo:");
		model.addAttribute("articulo", articulo);	
		return "articulo/form";
	}
	
	@GetMapping("/form/new")
	public String formArticuloGet(Model model) {	
		model.addAttribute("cabecera", "Formulario de articulo:");
		model.addAttribute("articulo", new Articulo());	
		return "articulo/form";
	}
	
	@PostMapping("/form")
	public String formArticuloPost(Articulo articulo) {
		articuloService.addArticulo(articulo);		
		return "redirect:/articulo/todos";
	}

}
