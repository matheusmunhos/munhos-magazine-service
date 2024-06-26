package com.munhos.magazine.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.munhos.magazine.service.domain.administrador.Administrador;
import com.munhos.magazine.service.domain.administrador.AdministradorRepository;
import com.munhos.magazine.service.domain.administrador.DadosAtualizarAdministrador;
import com.munhos.magazine.service.domain.administrador.DadosCadastroAdministrador;
import com.munhos.magazine.service.domain.administrador.DadosListagemAdministrador;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

	@Autowired
	AdministradorRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping
	@Transactional
	@CrossOrigin(origins = "*")
	public ResponseEntity<?> cadastrar(@RequestBody DadosCadastroAdministrador dados) {

		if (repository.existsByEmail(dados.email())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Administrador já cadastrado");
		}

		String senha = passwordEncoder.encode(dados.senha());

		var administrador = new Administrador(dados);
		administrador.setSenha(senha);

		repository.save(administrador);

		return ResponseEntity.ok(new Administrador(dados));

	}

	@CrossOrigin(origins = "*")
	@GetMapping
	public ResponseEntity<Page<DadosListagemAdministrador>> listar(
			@PageableDefault(size = 1000000, sort = { "nome" }) Pageable paginacao) {
		var page = repository.findAll(paginacao).map(DadosListagemAdministrador::new);
		return ResponseEntity.ok(page);
	}

	@PutMapping
	@Transactional
	@CrossOrigin(origins = "*")
	public void atualizar(@RequestBody DadosAtualizarAdministrador dados) {
		var administrador = repository.getReferenceById(dados.id());
		administrador.atualizarInformacoes(dados);
	}

	@DeleteMapping("{id}")
	@Transactional
	@CrossOrigin(origins = "*")
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
