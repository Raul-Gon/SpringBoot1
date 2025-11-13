package com.miempresa.segundocrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miempresa.segundocrud.entity.Edificio;
import com.miempresa.segundocrud.repository.IEdificioRepository;

@Service
public class EdificioServiceImpl implements IEdificioService {
	
	@Autowired
	private IEdificioRepository edificioRepository;
	
	@Override
	public List<Edificio> muestraTodos(){
		return edificioRepository.findAll();
	}

	
}
