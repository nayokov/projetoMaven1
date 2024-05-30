package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.domain.*;
import com.spring.domain.enums.EstadoPagamento;
import com.spring.domain.enums.TipoCliente;
import com.spring.repositories.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class ProjetoMaven1Application implements CommandLineRunner {

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
    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProjetoMaven1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Initial Data Setup
        setupInitialData();
    }

    private void setupInitialData() throws ParseException {
        Categoria categoria1 = new Categoria(null, "Informatica");
        Categoria categoria2 = new Categoria(null, "Escritorio");

        Produto produto1 = new Produto(null, "Computador", 4500.00);
        Produto produto2 = new Produto(null, "Monitor", 2000.00);
        Produto produto3 = new Produto(null, "Teclado", 480.00);

        categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
        categoria2.getProdutos().addAll(Arrays.asList(produto2));

        produto1.getCategorias().addAll(Arrays.asList(categoria1));
        produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
        produto3.getCategorias().addAll(Arrays.asList(categoria1));

        categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));

        Estado estado1 = new Estado(null, "Minas Gerais");
        Estado estado2 = new Estado(null, "Brasília");

        Cidade cidade1 = new Cidade(null, "Ceilandia", estado2);
        Cidade cidade2 = new Cidade(null, "Uberlandia", estado1);
        Cidade cidade3 = new Cidade(null, "Aguas Claras", estado2);

        estado1.getCidades().addAll(Arrays.asList(cidade2));
        estado2.getCidades().addAll(Arrays.asList(cidade1, cidade3));

        estadoRepository.saveAll(Arrays.asList(estado1, estado2));
        cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));

        Cliente cliente1 = new Cliente(null, "Maria", "maria@gmail.com", "45678898765", TipoCliente.PESSOAFISICA);
        cliente1.getTelefones().addAll(Arrays.asList("98898765545"));
        Cliente cliente2 = new Cliente(null, "Jose", "jo@gmail.com", "45454546789", TipoCliente.PESSOAFISICA);
        cliente2.getTelefones().addAll(Arrays.asList("98898765545", "61987766643"));
        Cliente cliente3 = new Cliente(null, "TIM", "TIM@gmail.com", "23456435476", TipoCliente.PESSOAJURIDICA);
        cliente3.getTelefones().addAll(Arrays.asList("98898765545", "61987266642", "61955556643"));

        Endereco end1 = new Endereco(null, "Rua Jeriva", "300", "Apto 303", "Jardim", "382838483", cliente1, cidade3);
        Endereco end2 = new Endereco(null, "Rua biribas", "200", "Apto 31", "Jardim", "234234234", cliente2, cidade2);
        Endereco end3 = new Endereco(null, "Rua milika", "111", "Apto 32", "Jardim", "56444545", cliente3, cidade3);
        Endereco end4 = new Endereco(null, "Rua Eard Three", "200", "Apto 65", "Jardim", "54422233", cliente3, cidade2);

        cliente1.getEnderecos().addAll(Arrays.asList(end1));
        cliente2.getEnderecos().addAll(Arrays.asList(end2));
        cliente3.getEnderecos().addAll(Arrays.asList(end3, end4));

        clienteRepository.saveAll(Arrays.asList(cliente1, cliente2, cliente3));
        enderecoRepository.saveAll(Arrays.asList(end1, end2, end3, end4));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Pedido pedido1 = new Pedido(null,sdf.parse("30/09/2020 00:00"), cliente1, end1);
        Pedido pedido2 = new Pedido(null,sdf.parse("10/10/2020 00:00"), cliente1, end2);
        Pedido pedido3 = new Pedido(null,sdf.parse("15/10/2020 00:00"), cliente3, end4);
        
        Pagamento pagamento1 = new PagamentoCartao(null,EstadoPagamento.QUITADO, pedido1,6);
        pedido1.setPagamento(pagamento1);
        Pagamento pagamento2 = new PagamentoCartao(null,EstadoPagamento.PENDENTE, pedido3,8);
        pedido2.setPagamento(pagamento2);
        Pagamento pagamento3 = new PagamentoBoleto(null,EstadoPagamento.PENDENTE,pedido2, sdf.parse("20/10/2020 00:00"), null);
        pedido3.setPagamento(pagamento3);
        
        cliente1.getPedidos().addAll(Arrays.asList(pedido1,pedido2,pedido3));
        pedidoRepository.saveAll(Arrays.asList(pedido1,pedido2,pedido3));
        pagamentoRepository.saveAll(Arrays.asList(pagamento1,pagamento2,pagamento3));
        
    }
}
