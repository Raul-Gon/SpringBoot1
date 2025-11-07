package com.miempresa.miprimercrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miempresa.miprimercrud.service.IClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	@Qualifier("clienteEnProducicion")
	private IClienteService clienteService;
	
	@ModelAttribute("titulo")
	public String titulo() {
		return "CLIENTES";
	}
	
	@GetMapping("/id/{id}")
	public String m(Model model, @PathVariable Long id) {
		model.addAttribute("cabecera", "Mostramos los datos del cliente:");
		model.addAttribute("cliente", clienteService.dameUnCliente(id));
		return "cliente/un-cliente";
	}

}
