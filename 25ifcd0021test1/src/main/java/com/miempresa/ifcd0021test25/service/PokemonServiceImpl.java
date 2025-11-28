package com.miempresa.ifcd0021test25.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.miempresa.ifcd0021test25.dto.PokemonFullDto;
import com.miempresa.ifcd0021test25.dto.PokemonSimpleDto;

@Service
public class PokemonServiceImpl implements IPokemonService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public PokemonSimpleDto getPokemonSimple(String pokemonName) {
		String url = "https://pokeapi.co/api/v2/pokemon/" + pokemonName;
		return restTemplate.getForObject(url, PokemonSimpleDto.class);
	}
	
	@Override
	public PokemonFullDto getPokemonFull(String pokemonName) {
		String url = "https://pokeapi.co/api/v2/pokemon/" + pokemonName;
		return restTemplate.getForObject(url, PokemonFullDto.class);
	}
	
}
