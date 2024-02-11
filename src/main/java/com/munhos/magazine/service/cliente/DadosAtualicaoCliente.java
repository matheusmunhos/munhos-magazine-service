package com.munhos.magazine.service.cliente;

import com.munhos.magazine.service.endereco.Endereco;

import jakarta.validation.constraints.NotNull;

public record DadosAtualicaoCliente(
		
		@NotNull
		Long cpf,
		
		String nome,
		String email,
		String telefone,
		Endereco endereco) {

}
