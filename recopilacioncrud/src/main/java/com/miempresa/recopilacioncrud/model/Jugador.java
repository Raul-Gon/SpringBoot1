package com.miempresa.recopilacioncrud.model;

public class Jugador {
	
	private String nombre;
	private int resultado;
	
	public Jugador() {
	}

	public Jugador(String nombre, int resultado) {
		this.nombre = nombre;
		this.resultado = resultado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	
			

}
