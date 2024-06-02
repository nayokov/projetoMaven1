package com.spring.services;

import java.util.List;
import java.util.Optional;

import com.spring.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.Pedido;
import com.spring.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
    private PedidoRepository repository;
	
	//public Categoria buscar(Integer id) {
	//	Optional<Categoria> obj = repository.findById(id);
	//	return obj.orElse(null);
	//}

	public List<Pedido> buscar() {
		return repository.findAll();
	}
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id + " Tipo: " +Pedido.class.getName()));
	}
	
}
