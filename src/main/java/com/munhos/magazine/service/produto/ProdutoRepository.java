package com.munhos.magazine.service.produto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	
	Page<Produto> findAllByAtivoTrue(Pageable paginacao);

	boolean existsByCodigoProduto(String codigoProduto);

	Object getReferenceByCodigoProduto(String codigoProduto);

	


}
