package com.munhos.magazine.service.domain.cliente;

import com.munhos.magazine.service.domain.endereco.Endereco;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "clientes")
@Entity(name = "Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

	@Id
	private Long cpf;

	private String nome;
	private String email;
	private String telefone;
	private Endereco endereco;

	public Cliente(DadosCadastroCliente dados) {
		this.nome = dados.nome();
		this.cpf = dados.cpf();
		this.email = dados.email();
		this.telefone = dados.telefone();
		this.endereco = new Endereco(dados.endereco());
	}

	public void atualizarInformacoes(DadosAtualicaoCliente dados) {

		if(dados.email() != null) {
			this.email = dados.email();
		} 
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		if (dados.telefone() != null) {
			this.telefone = dados.telefone();
		}
		if (dados.endereco() != null) {
			this.endereco.atualizarInformacoes(dados.endereco());
		}
	

	}
}