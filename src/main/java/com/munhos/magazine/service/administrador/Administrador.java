package com.munhos.magazine.service.administrador;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class Administrador implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String login;
	private String nome;
	private String email;
	private String senha;
	private String cpf;

	public Administrador(DadosCadastroAdministrador dados) {
		this.login = dados.login();
		this.nome = dados.nome();
		this.cpf = dados.cpf();
		this.email = dados.email();
		this.senha = dados.senha();
	}

	public void atualizarInformacoes(DadosAtualizarAdministrador dados) {

		if (dados.email() != null) {
			this.email = dados.email();

		}

		if (dados.senha() != null) {

			this.senha = dados.senha();
		}

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
	
		return senha;
	}

	@Override
	public String getUsername() {
	
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}
}