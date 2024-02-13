package com.munhos.magazine.service.domain.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto obterProdutoPorCodigo(String codigoProduto) {
        return produtoRepository.findByCodigoProduto(codigoProduto);
    }
}
