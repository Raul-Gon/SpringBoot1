package com.miempresa.miprimercrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miempresa.miprimercrud.entity.Articulo;
import com.miempresa.miprimercrud.repository.IArticuloRepository;

@Service("articuloEnProduccion") //le decimos que es un servicio y le ponemos el nombre para decirselo donde lo utliicemos ( en este caso lo utilizamos en articuloController)
public class ImplArticuloService implements IArticuloService {
	
	@Autowired //inyección automática de dependencias; que proporcione automáticamente una instancia de una clase (la dependencia) en otra clase, sin que tengas que crearla manualmente con new 
	private IArticuloRepository articuloRepository;

	@Override 
	public Articulo dameArticuloPorId(Long id) {
		return articuloRepository.findById(id).orElse(null);  //para buscar un articulo por el id y en caso de no encrontrarlo nos devuelve null
	}

	@Override
	public List<Articulo> dameTodosLosArticulos() {
		return articuloRepository.findAll(); // nos devuelve una lista con todos los articulos de la base de datos.
	}

	@Override
	public void borrarUnArticulo(Long id) {
		articuloRepository.deleteById(id);  //borramos un articulo de la BD con el id
	}

	@Override
	public Articulo addArticulo(Articulo articulo) {
		return articuloRepository.save(articulo); // añade o sustitulle el articulo, dependidendo de si tiene id, si lo tiene lo modifica, sino lo añade con un id nuevo.
	}

	@Override
	public List<Articulo> dameArticulosPortipo(String tipo) {
		return articuloRepository.findAllByTipo(tipo);  //selecciona una lista de articulos por tipo, este metodo no existia pero lo hemos definido en el Repository y solo nos lo ha creado.
	}

}
