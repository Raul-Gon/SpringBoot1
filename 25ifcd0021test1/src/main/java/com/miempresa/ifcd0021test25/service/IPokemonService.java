package com.miempresa.ifcd0021test25.service;

import com.miempresa.ifcd0021test25.dto.PokemonFullDto;
import com.miempresa.ifcd0021test25.dto.PokemonSimpleDto;

public interface IPokemonService {

	PokemonSimpleDto getPokemonSimple(String pokemonName);
	PokemonFullDto getPokemonFull(String pokemonName);
	
}
