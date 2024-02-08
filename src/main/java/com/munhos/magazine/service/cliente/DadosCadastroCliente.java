package com.munhos.magazine.service.cliente;

import com.munhos.magazine.service.endereco.DadosEndereco;

public record DadosCadastroCliente(String nome, Long cpf, String email,String telefone, DadosEndereco endereco) {

}
