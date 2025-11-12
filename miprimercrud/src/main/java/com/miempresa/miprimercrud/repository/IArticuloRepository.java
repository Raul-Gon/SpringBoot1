package com.miempresa.miprimercrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miempresa.miprimercrud.entity.Articulo;

public interface IArticuloRepository extends JpaRepository<Articulo, Long> {
	
	List<Articulo> findAllByTipo(String tipo);  //creamos un metodo en jpa poniendo una nomenclatura muy parecida a la de los metodos que nos ofrece, pero definiendo nosotros lo que nos devuelve y lo que le mandamos

}
