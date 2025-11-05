package com.miempresa.tercerproyecto.exceptions.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Biblioteca {
	
	private static Libro [] arrayBiblioteca = {
			new Libro("Cien años de soledad", true),
	        new Libro("1984", false),
	        new Libro("Un mundo feliz", true),
	        new Libro("Orgullo y prejuicio", true),
	        new Libro("Matar a un ruiseñor", false),
	        new Libro("El Gran Gatsby", true),
	        new Libro("Don Quijote de la Mancha", true),
	        new Libro("Moby Dick", false),
	        new Libro("Guerra y paz", true),
	        new Libro("Crimen y castigo", false),
	        new Libro("El guardián entre el centeno", true),
	        new Libro("El señor de los anillos", true),
	        new Libro("Harry Potter y la piedra filosofal", false),
	        new Libro("Los juegos del hambre", true),
	        new Libro("La naranja mecánica", false),
	        new Libro("Fahrenheit 451", true),
	        new Libro("Drácula", true),
	        new Libro("Frankenstein", false),
	        new Libro("El código Da Vinci", true),
	        new Libro("Crepúsculo", false)
		};
	
	private List<Libro> listaBiblioteca = new ArrayList<>();

	public Biblioteca() {
		listaBiblioteca = Arrays.asList(arrayBiblioteca);
	}
	
	public boolean addLibro(Libro lib) {
		boolean verificador = true;
		for (Libro libro : listaBiblioteca) {
			if (libro.getTitulo().equals(lib.getTitulo())) {
				System.out.println("Lo sentimos pero el libro ya existe en la Biblioteca.");
				return false;
			}
		}
		if (verificador) {
			listaBiblioteca.add(lib);
			System.out.printf("El libro: %s ha sido añadido a nuestra Biblioteca satisfactoriamente.", lib.getTitulo());
		}
		return verificador;
	}
	
	public void prestarLibro(Libro lib) {
		boolean existeLibro = true;
		for (Libro libro : listaBiblioteca) {
			if (libro.getTitulo().equals(lib.getTitulo())) {
				System.out.println("Lo sentimos pero el libro ya existe en la Biblioteca.");
				return false;
			}
		}
	}
	
}
