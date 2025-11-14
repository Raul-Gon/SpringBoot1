package com.miempresa.recopilacioncrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miempresa.recopilacioncrud.entity.Pregunta;

public interface IPreguntaRepository extends JpaRepository<Pregunta, Long> {

}
