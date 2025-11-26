package com.miempresa.miprimercrud;

import lombok.Data;

@Data
public class Prueba {
	
	private int size;
	
	
	public static void main(String[] args) {
		Prueba p = new Prueba();
		p.getSize();
		p.setSize(4);
	}

}
