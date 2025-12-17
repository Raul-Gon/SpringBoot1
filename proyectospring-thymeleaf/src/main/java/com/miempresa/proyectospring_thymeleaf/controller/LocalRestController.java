package com.miempresa.proyectospring_thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miempresa.proyectospring_thymeleaf.entity.Local;
import com.miempresa.proyectospring_thymeleaf.service.ILocalService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173/")
public class LocalRestController {
	
	@Autowired
	ILocalService localService;
	
	@GetMapping("/locales")
	public List<Local> listarLocales(){
		return localService.todosLosLocales();
	}
	
	@GetMapping("/locales/{id}")
	public Local listarUnLocalPorId(@PathVariable Long id) {
		return localService.localPorId(id);
	}
	
	@PostMapping("/locales")
	public Local crearLocal(@RequestBody Local local) {
		if(local.getId() == null) return localService.guardarLocal(local);
		return null;
	}

	@PutMapping("/locales/{id}")
	public Local actualizarLocal(@PathVariable Long id, @RequestBody Local local) {
		if(local.getId() != null && localService.localPorId(id) != null) return localService.guardarLocal(local);
		return null;
	}
	
	@DeleteMapping("/locales/{id}")
	public void borrarlocalPorId(@PathVariable Long id) {
		localService.borrarLocal(id);
	}	
}
