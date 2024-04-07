package com.munhos.magazine.service.domain.venda;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.munhos.magazine.service.domain.cliente.Cliente;
import com.munhos.magazine.service.domain.produto.Produto;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name ="vendas")
@Entity(name ="Venda")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Venda implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="codigoProduto")
	private Produto produto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="clienteCpf")
	private Cliente cliente;
	
	private Double valor;
	private Integer quantidade;
	private LocalDateTime data;
	
	
	
	   
	
	public Venda(Long id, Produto produto, Cliente cliente, LocalDateTime data,Double valor) {
		
		this.id = id;
		this.produto = produto;
		this.cliente = cliente;
		this.valor = valor;
		this.data = data;
	}
	
	
	
	

}
