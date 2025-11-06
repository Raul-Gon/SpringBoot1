package com.miempresa.tercerproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miempresa.tercerproyecto.service.PrimerService;
import com.miempresa.tercerproyecto.service.SegundoService;

@Controller
@RequestMapping("/1-servicios")
public class PrimerosServiciosController {
	
	@Autowired
	private PrimerService primerService;
	@Autowired
	private SegundoService segundoService;
	
	@GetMapping("/dime-algo")
	public String primeraPruebaServicio(Model model) {
		model.addAttribute("texto", primerService.dimeAlgo());
		
		return "primeros-servicios/main";
	}
	
	@GetMapping("/grita-algo")
	public String segundaPuebaServicios(Model model) {
		model.addAttribute("texto", primerService.gritaAlgo());
		
		return "primeros-servicios/main";
	}
	
	@GetMapping("/dame-un-numero")
	public String terceraPuebaServicios(Model model) {
		model.addAttribute("texto", segundoService.dameUnNumero());
		
		return "primeros-servicios/main";
	}
	
	@GetMapping("/dame-la-mitad/{valor}")
	public String cuartaPruebaServicio(Model model, @PathVariable int valor) {
		model.addAttribute("texto", segundoService.dameLaMitad(valor));
		
		return "primeros-servicios/main";
	}

}
