package com.munhos.magazine.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.munhos.magazine.service.domain.venda.DadosDetalhamentoVenda;
import com.munhos.magazine.service.domain.venda.DadosListagemVenda;
import com.munhos.magazine.service.domain.venda.DadosVenda;
import com.munhos.magazine.service.domain.venda.VendaRepository;
import com.munhos.magazine.service.domain.venda.VendasService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("vendas")
public class VendasController {

	@Autowired
	VendaRepository repository;

	@Autowired
	private VendasService venda;

	@CrossOrigin(origins = "*")
	@PostMapping
	@Transactional
	public ResponseEntity vender(@RequestBody DadosVenda dados) {
		venda.vender(dados);

		return ResponseEntity.ok(new DadosDetalhamentoVenda(null, null, null, null, null));
	}

	@CrossOrigin(origins = "*")
	@GetMapping
	public Page<DadosListagemVenda> listar(@PageableDefault(size = 100000, sort = { "data" }) Pageable paginacao) {
		return repository.findAll(paginacao).map(DadosListagemVenda::new);
	}

}
