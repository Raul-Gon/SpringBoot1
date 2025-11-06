package com.miempresa.tercerproyecto.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class PrimerService {
	
	private Random random = new Random();

	public String  dimeAlgo() {
		String[] textos = {"Hola", "Adios", "No"};
		return textos[random.nextInt(textos.length)];		
	}
	
	public String gritaAlgo() {
		String[] gritos = {"¡¡¡HOLAAAAAAAAAAAA!!!!!!", "¡¡¡ADIOOOOOOOOOOOSSSSS!!!", "¡¡¡NOOOOOOOOOOOOOOO!!!!!"};
		return gritos[random.nextInt(gritos.length)];
	}
}
