package com.miempresa.miprimercrud.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity  
@Table(name = "articulos")
public class Articulo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;  //define un identificador único para la versión de una clase que se puede serializar
	
	@Id  //le dice que es la clave de la tabla
	@GeneratedValue(strategy = GenerationType.IDENTITY) //le dice a la base de datos que el id lo genera ella y es la clave	
	private Long id;
	
	@Column(name="nombre") // si el nombre de abajo fuera nombrePrimero para la base de datos al poner esto usaria la columna nombre
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

	@Override
	public String toString() {
		return "Articulo [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento
				+ ", stock=" + stock + ", tipo=" + tipo + "]";
	}
	
	
}
