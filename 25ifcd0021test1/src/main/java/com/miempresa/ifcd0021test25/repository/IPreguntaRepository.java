package com.miempresa.ifcd0021test25.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miempresa.ifcd0021test25.entity.Dificultad;
import com.miempresa.ifcd0021test25.entity.Pregunta;

public interface IPreguntaRepository extends JpaRepository<Pregunta, Long> {
	List<Pregunta> findByDificultad(Dificultad dificultad);
	List<Pregunta> findByTema(String tema);

}
