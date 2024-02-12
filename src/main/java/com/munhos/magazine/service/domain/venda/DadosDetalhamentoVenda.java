package com.munhos.magazine.service.domain.venda;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public record DadosDetalhamentoVenda(Long id, String codigoProduto, Long clienteCpf,

		LocalDateTime data, Double valor) {

}
