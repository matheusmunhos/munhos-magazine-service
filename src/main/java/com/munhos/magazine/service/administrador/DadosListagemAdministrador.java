package com.munhos.magazine.service.administrador;

public record DadosListagemAdministrador(Long id,String nome, String email, String senha, String cpf) {

	public DadosListagemAdministrador(Administrador administrador) {
		this(administrador.getId(), administrador.getNome(), administrador.getEmail(), administrador.getSenha(), administrador.getCpf());
	}
}
