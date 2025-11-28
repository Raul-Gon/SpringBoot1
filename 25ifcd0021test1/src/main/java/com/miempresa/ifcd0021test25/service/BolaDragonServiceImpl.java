package com.miempresa.ifcd0021test25.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.miempresa.ifcd0021test25.dto.BolaDragonDto;

@Service
public class BolaDragonServiceImpl implements IBolaDragonService {

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public BolaDragonDto[] getBolaDragon(String nombre) {
		String url = "https://dragonball-api.com/api/characters?name=" + nombre;
		return restTemplate.getForObject(url, BolaDragonDto[].class);
	}
	
}
