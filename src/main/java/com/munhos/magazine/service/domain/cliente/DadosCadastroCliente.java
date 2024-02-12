package com.munhos.magazine.service.domain.cliente;

import com.munhos.magazine.service.domain.endereco.DadosEndereco;

public record DadosCadastroCliente(String nome, Long cpf, String email,String telefone, DadosEndereco endereco) {

}
