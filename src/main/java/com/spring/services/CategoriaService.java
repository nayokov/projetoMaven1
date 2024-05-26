package com.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.Categoria;
import com.spring.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
    private CategoriaRepository repository;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<Categoria> buscar() {
		
		return repository.findAll();
	}
}
