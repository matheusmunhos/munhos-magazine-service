package com.munhos.magazine.service.domain.produto;

public record DadosListagemProdutos(String nome,Integer quantidade,Double valor,String tipoProduto, Long id, String codigoProduto) {

	public DadosListagemProdutos(Produto produto) {
		this(produto.getNome(), produto.getQuantidade(), produto.getValor(),produto.getTipoProduto(), produto.getId(), produto.getCodigoProduto());
	}
}
