package com.munhos.magazine.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.munhos.magazine.service.domain.venda.DadosDetalhamentoVenda;
import com.munhos.magazine.service.domain.venda.DadosVenda;
import com.munhos.magazine.service.domain.venda.VendasService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("vendas")
public class VendasController {

	
	@Autowired
	private VendasService venda;
	
	@PostMapping
	@Transactional
	public ResponseEntity vender(@RequestBody DadosVenda dados) {
		venda.vender(dados);	
		
		return ResponseEntity.ok(new DadosDetalhamentoVenda(null, null, null, null, null));
	}
}
