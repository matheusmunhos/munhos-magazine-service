package com.munhos.magazine.service.produto;

public record DadosDetalhadamentoProduto(
		Long id,
		String nome,
		Double valor,
		Integer quantidade,
		String tipoProduto,
		Boolean ativo,
		String codigoProduto) {

	public DadosDetalhadamentoProduto(Produto produto) {
		this(produto.getId(),
				produto.getNome(),
				produto.getValor(),
				produto.getQuantidade(),
				produto.getTipoProduto(),
				produto.getAtivo(),
				produto.getCodigoProduto());
	}

	public DadosDetalhadamentoProduto(Object produto) {
		this(((Produto) produto).getId(),
				((Produto) produto).getNome(),
				((Produto) produto).getValor(),
				((Produto) produto).getQuantidade(),
				((Produto) produto).getTipoProduto(),
				((Produto) produto).getAtivo(),
				((Produto) produto).getCodigoProduto());
	}
}
