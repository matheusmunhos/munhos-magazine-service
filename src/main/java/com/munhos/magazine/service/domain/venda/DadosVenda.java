package com.munhos.magazine.service.domain.venda;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;

public record DadosVenda(
		@NotNull
		String codigoProduto,
		
		@NotNull
		Long clienteCpf,
		
		@NotNull
		Double valor,
		
		@NotNull
		Integer quantidade,
		
		@NotNull
		
		LocalDateTime data) {

}
