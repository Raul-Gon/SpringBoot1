package com.miempresa.tercerproyecto.exceptions.biblioteca;

public class Libro {
	
	private String titulo;
	private boolean estaPrestado;

	public Libro(String titulo, boolean estaPrestado) {
		this.titulo = titulo;
		this.estaPrestado = estaPrestado;
	}
	public Libro(String titulo) {
		this(titulo, false);
	}

	public String getTitulo() {
		return titulo;
	}
	public boolean isEstaPrestado() {
		return estaPrestado;
	}
	
	public void prestado() throws LibroYaPrestadoException {
		if (estaPrestado) {
			throw new LibroYaPrestadoException(titulo + " está ya prestado.");
		}
		
		estaPrestado = true;
	}
	
	public void devolver() {
		estaPrestado = false;
	}
}
