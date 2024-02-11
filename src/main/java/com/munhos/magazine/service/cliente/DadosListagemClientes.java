package com.munhos.magazine.service.cliente;

import com.munhos.magazine.service.endereco.Endereco;

public record DadosListagemClientes(Long cpf,String nome,String email, String telefone, Endereco endereco) {

	public DadosListagemClientes(Cliente cliente) {
		this(cliente.getCpf(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getEndereco());
	}
	
}
