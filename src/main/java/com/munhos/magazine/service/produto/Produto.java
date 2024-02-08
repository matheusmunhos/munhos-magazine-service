package com.munhos.magazine.service.produto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "produtos")
@Entity(name = "Produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private Double valor;
	private Integer quantidade;
	private String tipoProduto;
	


	public Produto(DadosCadastroProduto dados) {
		this.nome = dados.nome();
		this.valor = dados.valor();
		this.tipoProduto = dados.tipoProduto();
		this.quantidade = dados.quantidade();
	}



	public void atualizarInformacoes(DadosAtualizacaoProduto dados) {
		
		if (dados.nome() != null) {
			this.nome = dados.nome();			
		} 
		if (dados.quantidade() != null) {
			this.quantidade = dados.quantidade();
		}
		if (dados.valor() != null) {
			this.valor = dados.valor();
		}
		if (dados.tipoProduto() != null) {
			this.tipoProduto = dados.tipoProduto();
		}
		
	}
}