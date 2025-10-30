package com.miempresa.ejerciciopractico1.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Boleto {
	
	private List<Integer> numerosLoto = new ArrayList<>();
	private int bolas;
	private int numeros;
	private String pais;
	
	public Boleto(int bolas, int numeros, String pais) {
		this.bolas = bolas;
		this.numeros = numeros;
		this.pais = pais;
		
		Random rand = new Random();
		List<Integer> listaNumeros = new ArrayList<>();
		
		for(int i = 1; i < bolas+1; i++) {
			listaNumeros.add(i);
		}
		
		
		
	}
	
}
