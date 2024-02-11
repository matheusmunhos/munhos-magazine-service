package com.munhos.magazine.service.administrador;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarAdministrador (
		
		@NotNull
		Long id,
		String senha,
		String email) {

	
	
}
