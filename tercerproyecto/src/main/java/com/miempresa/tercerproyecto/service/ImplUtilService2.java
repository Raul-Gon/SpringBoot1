package com.miempresa.tercerproyecto.service;

import org.springframework.stereotype.Service;

@Service("elNuevo")
public class ImplUtilService2 implements IUtilService{

	@Override
	public String dameUnaCuenta() {
		String resultado = "";
		for (int i = 0; i < 20; i++) {
			resultado += (i + " " );
		}
		return resultado;
	}
	
}
