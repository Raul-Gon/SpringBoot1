package com.miempresa.segundocrud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "edificios")
public class Edificio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;  //define un identificador único para la versión de una clase que se puede serializar
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //le dice a la base de datos que el id lo genera ella y es la clave	
	private Long id;	
	
	private String denominacion;
	@Column(name= "numero_plantas")
	private byte numeroPlantas;
	private String calle;
	private boolean habitable;
	private char tipo;
	
	public Edificio() {
	}

	public Edificio(String denominacion, byte numeroPlantas, String calle, boolean habitable, char tipo) {
		this.denominacion = denominacion;
		this.numeroPlantas = numeroPlantas;
		this.calle = calle;
		this.habitable = habitable;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public byte getNumeroPlantas() {
		return numeroPlantas;
	}

	public void setNumeroPlantas(byte numeroPlantas) {
		this.numeroPlantas = numeroPlantas;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public boolean isHabitable() {
		return habitable;
	}

	public void setHabitable(boolean habitable) {
		this.habitable = habitable;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Edificio [id=" + id + ", denominacion=" + denominacion + ", numeroPlantas=" + numeroPlantas + ", calle="
				+ calle + ", habitable=" + habitable + ", tipo=" + tipo + "]";
	}
	
}
