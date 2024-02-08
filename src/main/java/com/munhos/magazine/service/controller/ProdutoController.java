package com.munhos.magazine.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.munhos.magazine.service.produto.DadosCadastroProduto;
import com.munhos.magazine.service.produto.DadosListagemProdutos;
import com.munhos.magazine.service.produto.Produto;
import com.munhos.magazine.service.produto.ProdutoRepository;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/produto")
public class ProdutoController {

	
	@Autowired
	ProdutoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody DadosCadastroProduto dados) {
		repository.save(new Produto(dados));
	}
	
	 @GetMapping
	public List<DadosListagemProdutos> listar(){
		return repository.findAll().stream().map(DadosListagemProdutos::new).toList();
	}
	
}
