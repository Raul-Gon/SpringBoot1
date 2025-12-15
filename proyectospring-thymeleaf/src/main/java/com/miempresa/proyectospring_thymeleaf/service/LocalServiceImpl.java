package com.miempresa.proyectospring_thymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miempresa.proyectospring_thymeleaf.entity.Local;
import com.miempresa.proyectospring_thymeleaf.repository.ILocalRepository;

@Service
public class LocalServiceImpl implements ILocalService {
	
	@Autowired
	private ILocalRepository localRepository;

	@Override
	public Local localPorId(Long id) {
		return localRepository.findById(id).orElse(null);
	}

	@Override
	public List<Local> todosLosLocales() {
		return localRepository.findAll();
	}

	@Override
	public Local localPorNombre(String nombre) {
		return localRepository.findByNombreCompleto(nombre).orElse(null);
	}

}
