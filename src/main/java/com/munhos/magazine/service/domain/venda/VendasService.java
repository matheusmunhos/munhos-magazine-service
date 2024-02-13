package com.munhos.magazine.service.domain.venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.munhos.magazine.service.service.VendaBancoService;

@Service
public class VendasService {


	@Autowired
	private VendaBancoService classeDeServico;

	public void vender(DadosVenda dados) {

		classeDeServico.salvarVenda(dados.clienteCpf(), dados.data(), dados.codigoProduto(), dados.valor(), dados.quantidade());
	}

}
