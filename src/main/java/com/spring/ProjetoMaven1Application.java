package com.spring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.domain.Categoria;
import com.spring.domain.Cidade;
import com.spring.domain.Cliente;
import com.spring.domain.Endereco;
import com.spring.domain.Estado;
import com.spring.domain.Produto;
import com.spring.domain.enums.TipoCliente;
import com.spring.repositories.CategoriaRepository;
import com.spring.repositories.CidadeRepository;
import com.spring.repositories.ClienteRepository;
import com.spring.repositories.EnderecoRepository;
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
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
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
    
    Cliente cliente1 = new Cliente(null,"Maria","maria@gmail.com","45678898765",TipoCliente.PESSOAFISICA);
    cliente1.getTelefones().addAll(Arrays.asList("98898765545"));
    Cliente cliente2 = new Cliente(null,"Jose","jo@gmail.com","45454546789",TipoCliente.PESSOAFISICA);
    cliente2.getTelefones().addAll(Arrays.asList("98898765545","61987766643"));
    Cliente cliente3 = new Cliente(null,"TIM","TIM@gmail.com","23456435476",TipoCliente.PESSOAJURIDICA);
    cliente3.getTelefones().addAll(Arrays.asList("98898765545","61987266642","61955556643"));
    
    Endereco end1 = new Endereco(null, "Rua Jeriva", "300", "Apto 303", "Jardim", "382838483",cliente1,cidade3);
    Endereco end2 = new Endereco(null, "Rua biribas", "200", "Apto 31", "Jardim", "234234234",cliente2,cidade2);
    Endereco end3 = new Endereco(null, "Rua milika", "111", "Apto 32", "Jardim", "56444545",cliente3,cidade3);
    Endereco end4 = new Endereco(null, "Rua Eard Three", "200", "Apto 65", "Jardim", "54422233",cliente3,cidade2);
    
    cliente1.getEnderecos().addAll(Arrays.asList(end1));
    cliente2.getEnderecos().addAll(Arrays.asList(end2));
    cliente3.getEnderecos().addAll(Arrays.asList(end3,end4));
    
    clienteRepository.saveAll(Arrays.asList(cliente1,cliente2,cliente3));
    enderecoRepository.saveAll(Arrays.asList(end1,end2,end3,end4));
    
	}
}