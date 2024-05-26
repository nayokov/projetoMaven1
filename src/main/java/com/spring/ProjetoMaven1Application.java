package com.spring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.domain.Categoria;
import com.spring.domain.Cidade;
import com.spring.domain.Estado;
import com.spring.domain.Produto;
import com.spring.repositories.CategoriaRepository;
import com.spring.repositories.CidadeRepository;
import com.spring.repositories.EstadoRepository;
import com.spring.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetoMaven1Application implements CommandLineRunner{ // CommandLineRunner auxilia para criar dados automaticamente na base H2
     
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoMaven1Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
	
	Categoria categoria1 = new Categoria(null,"Informatica");
	Categoria categoria2 = new Categoria(null,"Escritorio");
	
	Produto produto1 = new Produto(null,"Computador",4500.00);
	Produto produto2 = new Produto(null,"Monitor",2000.00);
	Produto produto3 = new Produto(null,"Teclado",480.00);
	 

	categoria1.getProdutos().addAll(Arrays.asList(produto1,produto2,produto3));
	categoria2.getProdutos().addAll(Arrays.asList(produto2));
	
    produto1.getCategorias().addAll(Arrays.asList(categoria1));
    produto2.getCategorias().addAll(Arrays.asList(categoria1,categoria2));
    produto3.getCategorias().addAll(Arrays.asList(categoria1));
    
    
    
    categoriaRepository.saveAll(Arrays.asList(categoria1,categoria2));
    produtoRepository.saveAll(Arrays.asList(produto1,produto2,produto3));
    
    Estado estado1 = new Estado(null,"Minas Gerais");
    Estado estado2 = new Estado(null,"Brasília");
    
    Cidade cidade1 = new Cidade(null,"Ceilandia",estado2);
    Cidade cidade2 = new Cidade(null,"Uberlandia",estado1);
    Cidade cidade3 = new Cidade(null,"Aguas Claras",estado2);
    
    estado1.getCidades().addAll(Arrays.asList(cidade2));
    estado2.getCidades().addAll(Arrays.asList(cidade1,cidade3));
    
    estadoRepository.saveAll(Arrays.asList(estado1,estado2));
    cidadeRepository.saveAll(Arrays.asList(cidade1,cidade2,cidade3));
    
	}
}