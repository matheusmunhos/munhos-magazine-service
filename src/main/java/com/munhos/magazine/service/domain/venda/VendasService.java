package com.munhos.magazine.service.domain.venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.munhos.magazine.service.domain.produto.ProdutoService;
import com.munhos.magazine.service.service.VendaBancoService;

@Service
public class VendasService {


	@Autowired
	private VendaBancoService classeDeServico;
	
	@Autowired
	ProdutoService produtoService;
	
	

	public void vender(DadosVenda dados) {
		int quantidade =produtoService.obterQuantidadePorCodigo(dados.codigoProduto());
		
		if(quantidade < dados.quantidade()) {
			throw new RuntimeException("Produto fora de estoque");
		}
		
		classeDeServico.salvarVenda(dados.clienteCpf(), dados.data(), dados.codigoProduto(), dados.valor(), dados.quantidade());
	}

}
