package com.munhos.magazine.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.munhos.magazine.service.administrador.Administrador;
import com.munhos.magazine.service.administrador.AdministradorRepository;
import com.munhos.magazine.service.administrador.DadosCadastroAdministrador;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/adm")
public class AdministradorController {

	@Autowired
	AdministradorRepository repository;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody DadosCadastroAdministrador dados) {
		repository.save(new Administrador(dados));
	}
}
