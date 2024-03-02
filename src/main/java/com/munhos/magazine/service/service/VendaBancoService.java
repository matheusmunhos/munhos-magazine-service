package com.munhos.magazine.service.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.munhos.magazine.service.domain.venda.Venda;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.constraints.NotNull;

@Service
public class VendaBancoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void salvarVenda(@NotNull Long cpf, @NotNull LocalDateTime data, String codigoProduto, @NotNull Double valor, Integer quantidade) {
        String sql = "INSERT INTO vendas (cliente_cpf, data, codigo_produto, valor, quantidade) VALUES (?, ?, ?, ?,?)";
        
        String sqlUp ="UPDATE produtos SET quantidade = quantidade - ? WHERE codigo_produto = ?";
        entityManager.createNativeQuery(sql)
            .setParameter(1, cpf)
            .setParameter(2, data)
            .setParameter(3, codigoProduto)
            .setParameter(4, valor)
            .setParameter(5, quantidade)
            .executeUpdate();
        
     
        	entityManager.createNativeQuery(sqlUp)
            .setParameter(1, quantidade)
            .setParameter(2, codigoProduto)
            .executeUpdate();
        
        
    }
    
    public List<?> listarTodasAsVendas() {
        String jpql = "SELECT v FROM Venda v";
        return entityManager.createQuery(jpql, Venda.class)
            .getResultList();
    }
    
    
    
    
}
