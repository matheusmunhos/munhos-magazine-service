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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.munhos.magazine.service.domain.cliente.Cliente;
import com.munhos.magazine.service.domain.cliente.ClienteRepository;
import com.munhos.magazine.service.domain.cliente.DadosAtualicaoCliente;
import com.munhos.magazine.service.domain.cliente.DadosCadastroCliente;
import com.munhos.magazine.service.domain.cliente.DadosDetalhamentoCliente;
import com.munhos.magazine.service.domain.cliente.DadosListagemClientes;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteRepository repository;

	@CrossOrigin(origins = "*")
	@PostMapping
	@Transactional
	public ResponseEntity<Object> cadastrar(@RequestBody DadosCadastroCliente dados, UriComponentsBuilder uriBuilder) {
		if (repository.existsByCpf(dados.cpf())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente já cadastrado");
		}
		var cliente = new Cliente(dados);
		var uri = uriBuilder.path("cliente/{cpf}").buildAndExpand(cliente.getCpf()).toUri();

		repository.save(cliente);

		return ResponseEntity.created(uri).body(new DadosDetalhamentoCliente(cliente));
	}

	@CrossOrigin(origins = "*")
	@GetMapping
	public ResponseEntity<Page<DadosListagemClientes>> listar(
			
			@PageableDefault(size = 100000, sort = { "nome" }) Pageable paginacao) {
		var page = repository.findAll(paginacao).map(DadosListagemClientes::new);
		return ResponseEntity.ok(page);
	}

	@CrossOrigin(origins = "*")
	@PutMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoCliente> atualizar(@RequestBody DadosAtualicaoCliente dados) {
		var cliente = repository.getReferenceById(dados.cpf());
		cliente.atualizarInformacoes(dados);

		return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("{cpf}")
	@Transactional
	public ResponseEntity<?> excluir(@PathVariable Long cpf) {
		repository.deleteById(cpf);
		return ResponseEntity.noContent().build();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("{cpf}")
	public ResponseEntity<DadosDetalhamentoCliente> detalhar(@PathVariable Long cpf) {
		var cliente = repository.getReferenceById(cpf);
		return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
	}

}
