package com.munhos.magazine.service.domain.venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.munhos.magazine.service.domain.cliente.Cliente;
import com.munhos.magazine.service.domain.cliente.ClienteRepository;
import com.munhos.magazine.service.domain.produto.Produto;
import com.munhos.magazine.service.domain.produto.ProdutoRepository;

@Service
public class VendasService {

	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private VendasService service;
	
	public void vender(DadosVenda dados) {
		
		
		
		
		//var cliente = clienteRepository.findByCpf(dados.clienteCpf());
		//var produto = produtoRepository.getReferenceByCodigoProduto(dados.codigoProduto());

		var prod  = service.escolherProduto(dados);
		var cliente = service.escolherCliente(dados);
		
		var venda = new Venda(null, prod, cliente, dados.valor(), dados.data());

		
		vendaRepository.save(venda);
		
	}
	
	private Produto escolherProduto(DadosVenda dados) {
		
		var prod = produtoRepository.getReferenceByCodigoProduto(dados.codigoProduto());
		
		Produto produ = prod;
		
		
		return produ;
		
	}
	
	private Cliente escolherCliente (DadosVenda dados) {
		var clien = clienteRepository.findByCpf(dados.clienteCpf());
		
		Cliente cliente = clien;
		return cliente;
	}
	
	
}
