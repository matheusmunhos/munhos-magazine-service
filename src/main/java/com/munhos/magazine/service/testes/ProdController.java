package com.munhos.magazine.service.testes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.munhos.magazine.service.domain.produto.Produto;
import com.munhos.magazine.service.domain.produto.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdController {

    private ProdutoService produtoService;

    @Autowired
    public void ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/{codigoProduto}")
    public Produto obterProdutoPorCodigo(@PathVariable String codigoProduto) {
        return produtoService.obterProdutoPorCodigo(codigoProduto);
    }
}
