package com.munhos.magazine.service.administrador;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "administradores")
@Entity(name = "Administrador")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Administrador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String email;
	private String senha;
	private String cpf;
	


	public Administrador(DadosCadastroAdministrador dados) {
		this.nome = dados.nome();
		this.cpf = dados.cpf();
		this.email = dados.email();
		this.senha = dados.senha();
	}
}