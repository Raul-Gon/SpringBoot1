package com.miempresa.segundoproyecto.model;

public class Animal {
	
	private double precio;
	private int peso;
	private String tipo;
	
	public Animal(double precio, int peso, String tipo) {
		this.precio = precio;
		this.peso = peso;
		this.tipo = tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public int getPeso() {
		return peso;
	}

	public String getTipo() {
		return tipo;
	}
		
}
