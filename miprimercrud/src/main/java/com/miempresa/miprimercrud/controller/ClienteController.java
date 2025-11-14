package com.miempresa.miprimercrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.miempresa.miprimercrud.entity.Cliente;
import com.miempresa.miprimercrud.service.IClienteService;

import jakarta.validation.Valid;

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
	public String clienteById(Model model, @PathVariable Long id) {
		model.addAttribute("cabecera", "Mostramos los datos del cliente:");
		model.addAttribute("cliente", clienteService.dameUnCliente(id));
		return "cliente/un-cliente";
	}

	@GetMapping("/todos")
	public String allClientes(Model model) {
		model.addAttribute("cabecera", "Mostramos lista de clientes:");
		model.addAttribute("clientes", clienteService.dameTodosLosClientes());		
		return "cliente/clientes";
	}
	
	@GetMapping("/borrar/{id}")
	public String borraClienteById(@PathVariable long id, RedirectAttributes flash) {
		clienteService.borrarUnCliente(id);	
		flash.addFlashAttribute("warning", "Cliente borrado con exito");
		return "redirect:/cliente/todos";
		
	}
	
	@GetMapping("/form/{id}")
	public String formClienteGet(Model model, @PathVariable long id) {
		Cliente cliente = id == -1 ? new Cliente() : clienteService.dameUnCliente(id);		
		model.addAttribute("cabecera", "Formulario de cliente:");
		model.addAttribute("cliente", cliente);	
		return "cliente/form";
	}
	
	@PostMapping("/form")
	public String formClientePost(@Valid Cliente cliente, BindingResult result, RedirectAttributes flash, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("cabecera", "Formulario de cliente:");
			model.addAttribute("cliente", cliente);	
			return "cliente/form";
		}		
		clienteService.addCliente(cliente);		
		flash.addFlashAttribute("succes", "Cliente guardado");
		return "redirect:/cliente/todos";
	}
}
