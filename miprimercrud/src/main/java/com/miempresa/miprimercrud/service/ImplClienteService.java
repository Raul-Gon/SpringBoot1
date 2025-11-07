package com.miempresa.miprimercrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miempresa.miprimercrud.entity.Cliente;
import com.miempresa.miprimercrud.repository.IClienteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service("clienteEnProducicion")
public class ImplClienteService implements IClienteService {
	
	@Autowired
	private IClienteRepository clienteRepository;

	@Override
	public Cliente dameUnCliente(Long id) {
		return clienteRepository.findById(id).orElse(null);	
	}

}
