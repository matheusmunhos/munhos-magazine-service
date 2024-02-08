package com.munhos.magazine.service.produto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProduto(
		
		@NotNull
		Long id,
		
		String nome,
		Double valor,
		Integer quantidade,
		String tipoProduto) {

}
