package com.miempresa.ejerciciopractico1corregido.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ciudad {

	private static int nextId = 0;
	private int id;
	private String nombre;
	private String foto;
	private static Random random = new Random();
	private static Ciudad[] catalogo = {
										new Ciudad("sevilla", "sevilla.jpg"),
										new Ciudad("madrid", "madrid.jpg"),
										new Ciudad("toledo", "toledo.jpg")
									};

	public Ciudad(String nombre, String foto) {
		this.id = nextId++;
		this.nombre = nombre;		
		this.foto = foto;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getFoto() {
		return foto;
	}

	public static Ciudad[] catalogo() {
		return catalogo;
	}
	
	public static Ciudad ciudadAleatoria() {
		return catalogo[random.nextInt(0, catalogo.length)];
	}
	
	public static boolean validaRespuesta(int id, String ciudad) {
		for (Ciudad c : catalogo) {
			if (c.id == id) {
				return c.nombre.equalsIgnoreCase(ciudad); 
			}
		}
		return false;
	}
	
}
