package com.munhos.magazine.service.produto;

public record DadosListagemProdutos(String nome,Integer quantidade,Double valor,String tipoProduto) {

	public DadosListagemProdutos(Produto produto) {
		this(produto.getNome(), produto.getQuantidade(), produto.getValor(),produto.getTipoProduto());
	}
}
