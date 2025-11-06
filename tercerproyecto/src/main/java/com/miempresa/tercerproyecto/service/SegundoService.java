package com.miempresa.tercerproyecto.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class SegundoService {
	
	private Random random = new Random();
	
	public int dameUnNumero() {
		return random.nextInt(1, 101);
	}

	public int dameLaMitad(int n) {
		return n/2;
	}
	
}
