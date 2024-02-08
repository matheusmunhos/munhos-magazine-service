package com.munhos.magazine.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.munhos.magazine.service.cliente.Cliente;
import com.munhos.magazine.service.cliente.ClienteRepository;
import com.munhos.magazine.service.cliente.DadosCadastroCliente;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody DadosCadastroCliente dados) {
		repository.save(new Cliente(dados));
	}
}
