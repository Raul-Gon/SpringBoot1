package com.miempresa.tercerproyecto.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(NullPointerException.class)
	public String m1(Model model, NullPointerException ex) {
		//vista de error de null pointer
		model.addAttribute("mensaje", ex);
		return "error/vista-null";
	}

	@ExceptionHandler(ArithmeticException.class)
	public String m2() {
		//vista de error de division por 0
		return "error/vista-cero";
	}
	
}
