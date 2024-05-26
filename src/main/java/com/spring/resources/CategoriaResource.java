package com.spring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.Categoria;
import com.spring.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	@Autowired
	private CategoriaService service;

	@RequestMapping(value = "/{idCategoria}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer idCategoria) {
    Categoria obj = service.find(idCategoria);
		
		return ResponseEntity.ok().body(obj);
	}
	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> findAll() {
	    List<Categoria> obj = service.buscar();
			
			return obj;
		}
}
