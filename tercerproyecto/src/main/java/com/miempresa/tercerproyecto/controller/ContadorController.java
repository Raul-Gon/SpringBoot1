package com.miempresa.tercerproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miempresa.tercerproyecto.service.IUtilService;

@Controller
@RequestMapping("/utils")
public class ContadorController {
	
	@Autowired
	@Qualifier("elNuevo")
	private IUtilService utilService;
		
	@ModelAttribute("titulo")
	public String titulo() {
		return "Utilidades";
	}
	
	@GetMapping("/cuenta")
	public String cuentaHandler(Model model) {
		model.addAttribute("cabecera", "Contando:");
		model.addAttribute("mensaje", utilService.dameUnaCuenta());
		return "utils/main";
	}

}
