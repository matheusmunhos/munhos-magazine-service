package com.munhos.magazine.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.munhos.magazine.service.produto.DadosAtualizacaoProduto;
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
	public Page<DadosListagemProdutos> listar(@PageableDefault(size=10,sort= {"nome"}) Pageable paginacao){
		return repository.findAll(paginacao).map(DadosListagemProdutos::new);
	}
	 
	 @PutMapping
	 @Transactional
	 public void atualizar(@RequestBody DadosAtualizacaoProduto dados) {
		 var produto = repository.getReferenceById(dados.id());
		 produto.atualizarInformacoes(dados);
	 }
	
}
