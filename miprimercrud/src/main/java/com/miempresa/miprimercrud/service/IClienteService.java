package com.miempresa.miprimercrud.service;

import java.util.List;

import com.miempresa.miprimercrud.entity.Cliente;

public interface IClienteService {

	Cliente dameUnCliente(Long id);
	List<Cliente> dameTodosLosClientes();
	void borrarUnCliente(Long id);
	Cliente addCliente(Cliente cliente);
	
}
