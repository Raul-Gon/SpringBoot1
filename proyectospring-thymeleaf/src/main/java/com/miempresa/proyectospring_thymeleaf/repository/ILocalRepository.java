package com.miempresa.proyectospring_thymeleaf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miempresa.proyectospring_thymeleaf.entity.Local;

public interface ILocalRepository extends JpaRepository<Local, Long> {
	Optional<Local> findByNombreCompleto(String nombre);
}
