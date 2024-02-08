package com.munhos.magazine.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.munhos.magazine.service.cliente.Cliente;
import com.munhos.magazine.service.cliente.ClienteRepository;
import com.munhos.magazine.service.cliente.DadosAtualicaoCliente;
import com.munhos.magazine.service.cliente.DadosCadastroCliente;
import com.munhos.magazine.service.cliente.DadosListagemClientes;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteRepository repository;

	@PostMapping
	@Transactional
	public ResponseEntity<String> cadastrar(@RequestBody DadosCadastroCliente dados) {
		if (repository.existsByCpf(dados.cpf())) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CPF já cadastrado");
	    }

	    // Se o CPF não existe, salvar o cliente
	    repository.save(new Cliente(dados));
	    return ResponseEntity.status(HttpStatus.CREATED).body("Cliente cadastrado com sucesso");
	}

	@GetMapping
	public Page<DadosListagemClientes> listar(@PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao) {
		return repository.findAll(paginacao).map(DadosListagemClientes::new);
	}

	 @PutMapping
	 @Transactional
	 public void atualizar(@RequestBody DadosAtualicaoCliente dados) {
		 var cliente = repository.getReferenceById(dados.cpf());
		 cliente.atualizarInformacoes(dados);
	 }
	 
}
