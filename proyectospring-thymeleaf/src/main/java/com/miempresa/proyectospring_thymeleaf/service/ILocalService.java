package com.miempresa.proyectospring_thymeleaf.service;

import java.util.List;

import com.miempresa.proyectospring_thymeleaf.entity.Local;

public interface ILocalService {
	
	Local localPorId(Long id);
	List<Local> todosLosLocales();
	Local localPorNombre(String nombre);
	void borrarLocal(Long id);
	Local guardarLocal(Local local);

}
