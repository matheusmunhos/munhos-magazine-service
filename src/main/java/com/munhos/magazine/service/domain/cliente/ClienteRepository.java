package com.munhos.magazine.service.domain.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	

	boolean existsByCpf(Long cpf);
	Cliente findByCpf(Long cpf);
	//Cliente findbyCpf(Long cpf);
	

}
