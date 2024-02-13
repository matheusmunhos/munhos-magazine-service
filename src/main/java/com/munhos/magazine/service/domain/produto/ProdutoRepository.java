package com.munhos.magazine.service.domain.produto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	
	Page<Produto> findAllByAtivoTrue(Pageable paginacao);

	boolean existsByCodigoProduto(String codigoProduto);

	Produto getReferenceByCodigoProduto(String codigoProduto);

	Produto findByCodigoProduto(String codigoProduto);


}
