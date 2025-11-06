package com.miempresa.tercerproyecto.exceptions.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca2 {
	
	private static List<Libro2> lista = generaLista(); 
	
	private static List<Libro2> generaLista(){
		List<Libro2> listado = new ArrayList<>();
		listado.add(new Libro2("libro 1"));
		listado.add(new Libro2("libro 2"));
		listado.add(new Libro2("libro 3"));
		listado.add(new Libro2("libro 4"));
		listado.add(new Libro2("libro 5"));
		listado.add(new Libro2("libro 6"));
		listado.add(new Libro2("libro 7"));
		listado.add(new Libro2("libro 8"));
		return listado;
	}
	
	public static boolean add(String titulo) {
		if(titulo == null || titulo.trim().equals("")) return false;
		
		for (Libro2 li : lista) {
			if(titulo.equals(li.getTitulo())) {
				return false;
			}
		}
		
		lista.add(new Libro2(titulo));
		return true;
	}
	
	public static void prestar(String titulo) throws LibroNoExistenteException, LibroYaPrestadoException {
		if(titulo == null || titulo.trim().equals(""))
			throw new LibroNoExistenteException("Titulo NULL o VACIO.");
		
		for (Libro2 li : lista) {
			if(titulo.equals(li.getTitulo())) {
				li.prestar();
				return;
			}
		}
		
		throw new LibroNoExistenteException("El libro " + titulo + " no está en la biblioteca.");
	}
	
	public static void devolver(String titulo) throws LibroNoExistenteException, LibroNoPrestadoException {
		if(titulo == null)
			throw new LibroNoExistenteException("Titulo NULL.");
		
		for (Libro2 li : lista) {
			if(titulo.equals(li.getTitulo())) {
				li.devolver();
				return;
			}
		}
		
		throw new LibroNoExistenteException("El libro " + titulo + " no está en la biblioteca.");
	}
	
}
