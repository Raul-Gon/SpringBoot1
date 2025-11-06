package com.miempresa.tercerproyecto.exceptions.biblioteca;

public class Test {

	public static void main(String[] args) {
		
		try {
			Biblioteca2.prestar("");
		} catch (LibroNoExistenteException e) {
			System.out.println("Exception: " + e.getClass().getSimpleName() + " " + e.getMessage());
			e.printStackTrace();
		} catch (LibroYaPrestadoException e) {
			e.printStackTrace();
		}
		
		System.out.println("Hemos prestado el libro 2 por primera vez.");
		
		try {
			Biblioteca2.prestar("libro 2");
		} catch (LibroNoExistenteException e) {
			e.printStackTrace();
		} catch (LibroYaPrestadoException e) {
			e.printStackTrace();
		}
		
		System.out.println("Hemos intentado prestar otra vez el libro 2.");
		
	}
}
