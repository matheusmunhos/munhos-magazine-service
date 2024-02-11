package com.munhos.magazine.service.administrador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

	boolean existsByEmail(String email);

	UserDetails findByLogin(String login);

}
