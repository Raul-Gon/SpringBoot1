package com.miempresa.ifcd0021test25.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonFullDto {
	
	
	private String name;   //<- nombre EXACTO de la clave JSON hacer  getters y setters...
	private Sprites sprites; //<- nombre EXACTO de la clave JSON hacer  getters y setters...

	public static class Sprites {
		@JsonProperty("front_default")
	    private String frontDefault; // <- nombre EXACTO de la clave JSON
		@JsonProperty("back_default")
	    private String backDefault; // <- clave para la parte trasera
	    
	    // getters y setters...
	    public String getBackDefault() {
			return backDefault;
		}

		public void setBackDefault(String backDefault) {
			this.backDefault = backDefault;
		}

		public String getFrontDefault() {
			return frontDefault;
		}

		public void setFrontDefault(String frontDefault) {
			this.frontDefault = frontDefault;
		}	    
	}
	
	public PokemonFullDto() {
	}

	public Sprites getSprites() {
		return sprites;
	}

	public void setSprites(Sprites sprites) {
		this.sprites = sprites;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
