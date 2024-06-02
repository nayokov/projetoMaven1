package com.spring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.Pedido;
import com.spring.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	@Autowired
	private PedidoService service;

	@RequestMapping(value = "/{idPedido}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer idPedido) {
		Pedido obj = service.find(idPedido);
		
		return ResponseEntity.ok().body(obj);
	}
	@RequestMapping(method = RequestMethod.GET)
	public List<Pedido> findAll() {
	    List<Pedido> obj = service.buscar();
			
			return obj;
		}
}
