package com.miempresa.segundoproyecto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/xaludar")
public class XaludoController {
	
	@GetMapping({"/1", "/uno"})
	public String s1(Model model) {
		model.addAttribute("mensaje", "Buenos dias");
		return "/xaludo/xaludar";
	}
	
	@GetMapping({"2", "dos"})
	public String s2(Model model) {
		model.addAttribute("mensaje", "Buenas Tardes");
		return "/xaludo/xaludar";
	}
	
	@GetMapping({"3", "tres"})
	public String s3(Model model) {
		model.addAttribute("mensaje", "Buenas noches");
		return "/xaludo/xaludar";
	}

}
