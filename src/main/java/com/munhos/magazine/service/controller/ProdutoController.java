package com.munhos.magazine.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.munhos.magazine.service.domain.produto.DadosAtualizacaoProduto;
import com.munhos.magazine.service.domain.produto.DadosCadastroProduto;
import com.munhos.magazine.service.domain.produto.DadosDetalhadamentoProduto;
import com.munhos.magazine.service.domain.produto.DadosListagemProdutos;
import com.munhos.magazine.service.domain.produto.Produto;
import com.munhos.magazine.service.domain.produto.ProdutoRepository;
import com.munhos.magazine.service.domain.produto.ProdutoService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	ProdutoRepository repository;

	@Autowired
	ProdutoService produtoService;

	@CrossOrigin(origins = "*")
	@PostMapping
	@Transactional
	public ResponseEntity<Object> cadastrar(@RequestBody DadosCadastroProduto dados, UriComponentsBuilder uriBuilder) {
		if (repository.existsByCodigoProduto(dados.codigoProduto())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produto já cadastrado");
		}

		var produto = new Produto(dados);
		var uri = uriBuilder.path("produto/{id}").buildAndExpand(produto.getCodigoProduto()).toUri();

		repository.save(produto);

		return ResponseEntity.created(uri).body(new DadosDetalhadamentoProduto(produto));
	}

	@CrossOrigin(origins = "*")
	@GetMapping
	public Page<DadosListagemProdutos> listar(@PageableDefault(size = 100000, sort = { "nome" }) Pageable paginacao) {
		return repository.findAllByAtivoTrue(paginacao).map(DadosListagemProdutos::new);
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/atualizar{cdProduto}")
	@Transactional
	public ResponseEntity<String> atualizar(@RequestParam String cdProduto,
			@RequestBody DadosAtualizacaoProduto dados) {
		var produto = repository.getReferenceByCodigoProduto(cdProduto);
		((Produto) produto).atualizar(dados);
		

		return ResponseEntity.ok("Produto atualizado com sucesso com sucesso!");
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		var produto = repository.getReferenceById(id);
		produto.excluir();

	}

	@CrossOrigin(origins = "*")
	@GetMapping("{codigoProduto}")
	public ResponseEntity<DadosDetalhadamentoProduto> detalhar(@PathVariable String codigoProduto) {
		var produto = repository.getReferenceByCodigoProduto(codigoProduto);
		return ResponseEntity.ok(new DadosDetalhadamentoProduto(produto));
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/vender")
	@Transactional
	public ResponseEntity<String> venderProduto(@RequestParam String cdproduto, @RequestParam Integer quantidade) {

		var produto = repository.getReferenceByCodigoProduto(cdproduto);
		((Produto) produto).vendaMercadoria(quantidade);

		return ResponseEntity.ok("Venda realizada com sucesso!");
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/repor")
	@Transactional
	public ResponseEntity<String> reporProduto(@RequestParam String cdproduto, @RequestParam Integer quantidade) {

		var produto = repository.getReferenceByCodigoProduto(cdproduto);
		((Produto) produto).reporMercadoria(quantidade);

		return ResponseEntity.ok("Produto reposto com sucesso!");
	}

}
