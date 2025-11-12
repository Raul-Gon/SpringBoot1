package com.miempresa.miprimercrud.service;

import java.util.List;

import com.miempresa.miprimercrud.entity.Articulo;

public interface IArticuloService {

	Articulo dameArticuloPorId(Long id);
	List<Articulo> dameTodosLosArticulos();
	void borrarUnArticulo(Long id);
	Articulo addArticulo(Articulo articulo);
	List<Articulo>dameArticulosPortipo(String tipo);
}
