package com.munhos.magazine.service.domain.produto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProduto(
		
		@NotNull
		Long id,
		
		String nome,
		Double valor,
		Integer quantidade,
		String tipoProduto,
		String codigoProduto) {

}
