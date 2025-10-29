package com.miempresa.segundoproyecto.model;

public class Articulo {
	
	private String nombre;
	private int cantidad;
	private double precio;
	private String color;
	
	public Articulo(String nombre, int cantidad, double precio, String color) {
		this.nombre = nombre != null ? nombre : "Sin Nombre";
		this.cantidad = cantidad > 0 ? cantidad : 0;
		this.precio = precio > 0 ? precio : 1;
		this.color = color != null ? color : "negro";
	}

	public String getNombre() {
		return nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public String getColor() {
		return color;
	}
	
}
