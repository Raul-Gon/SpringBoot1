package com.miempresa.tercerproyecto.service;

import org.springframework.stereotype.Service;

@Service("elAntiguo")
public class ImplUtilService implements IUtilService{

	@Override
	public String dameUnaCuenta() {
		String resultado = "";
		for (int i = 0; i < 10; i++) {
			resultado += (i + " " );
		}
		return resultado;
	}
	
}
