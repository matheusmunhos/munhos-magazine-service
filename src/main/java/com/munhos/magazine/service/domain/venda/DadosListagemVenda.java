package com.munhos.magazine.service.domain.venda;

import java.time.LocalDateTime;

import com.munhos.magazine.service.domain.cliente.Cliente;
import com.munhos.magazine.service.domain.produto.Produto;

public record DadosListagemVenda(Long id,  Double valor, Integer quantidade, LocalDateTime data, Produto produto, Cliente cliente ) {

	public DadosListagemVenda(Venda venda) {
		this(venda.getId(),
				venda.getValor(),
				venda.getQuantidade(),
				venda.getData(),
				venda.getProduto(),
				venda.getCliente());
				
				
	}
}
