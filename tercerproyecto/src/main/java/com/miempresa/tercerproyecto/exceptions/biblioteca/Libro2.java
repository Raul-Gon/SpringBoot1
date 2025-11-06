package com.miempresa.tercerproyecto.exceptions.biblioteca;

public class Libro2 {
	
	private String titulo;
	private boolean prestado;
	
	public Libro2(String titulo) {
		super();
		this.titulo = titulo;
		prestado = false;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void prestar() throws LibroYaPrestadoException {
		if(prestado) throw new LibroYaPrestadoException("El libro " + titulo + " ya está prestado.");
		
		prestado = true;				
	}
	
	public void devolver() throws LibroNoPrestadoException {
		if(!prestado) throw new LibroNoPrestadoException("El libro " + titulo + " ya está prestado.");
		
		prestado = false;
	}
	
}
