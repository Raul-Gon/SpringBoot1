package com.miempresa.tercerproyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
	
	@GetMapping("/simulacion-error-null")
	public String errorNull() {
		String otro = null;
		otro.length();
		return "error/404";
	}
	
	@GetMapping("/simulacion-error-div-0")
	public String errorDiv() {
		int i = 10/0;
		return "";
	}

}
