package com.miempresa.primerproyecto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HolaControler {

	@GetMapping("/hola-mundo") 
	public String m() {
		return "hola";
	}
	
}
