package com.munhos.magazine.service.domain.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {

        this.produtoRepository = produtoRepository;
    }

    public Produto obterProdutoPorCodigo(String codigoProduto) {
        return produtoRepository.findByCodigoProduto(codigoProduto);
    }
    public int obterQuantidadePorCodigo(String codigoProduto) {
        Produto produto = produtoRepository.findByCodigoProduto(codigoProduto);
        return produto != null ? produto.getQuantidade() : 0;
    }
}
