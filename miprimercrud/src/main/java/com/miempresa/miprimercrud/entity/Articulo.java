package com.miempresa.miprimercrud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "articulos")
public class Articulo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	private String nombre;
	private double precio;
	private byte descuento;
	private int stock;
	private String tipo;
	
	public Articulo() {
	}

	public Articulo(String nombre, double precio, byte descuento, int stock, String tipo) {
		this.nombre = nombre;
		this.precio = precio;
		this.descuento = descuento;
		this.stock = stock;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public byte getDescuento() {
		return descuento;
	}
	public void setDescuento(byte descuento) {
		this.descuento = descuento;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
