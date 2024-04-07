package com.munhos.magazine.service.domain.cliente;

import com.munhos.magazine.service.domain.endereco.Endereco;

import jakarta.validation.constraints.NotNull;

public record DadosAtualicaoCliente(
		
		@NotNull
		Long cpf,
		
		String nome,
		String email,
		String telefone,
		Endereco endereco) {

}
