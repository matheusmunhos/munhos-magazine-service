package com.munhos.magazine.service.domain.produto;

import org.springframework.http.ResponseEntity;

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
	private Boolean ativo;
	private String codigoProduto;

	public Produto(DadosCadastroProduto dados) {
		this.ativo = true;
		this.nome = dados.nome();
		this.valor = dados.valor();
		this.tipoProduto = dados.tipoProduto();
		this.quantidade = dados.quantidade();
		this.codigoProduto = dados.codigoProduto();
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
		if (dados.codigoProduto() != null) {
			this.codigoProduto = dados.codigoProduto();
		}

	}

	public void excluir() {
		this.ativo = false;

	}

	public ResponseEntity<String> vendaMercadoria(Integer i) {
		if (i > this.quantidade) {
			return (ResponseEntity) ResponseEntity.internalServerError();
		}
		this.quantidade = quantidade - i;
		return ResponseEntity.ok("Venda realizada");
	}

	public ResponseEntity<String> reporMercadoria(Integer i) {
		if (i > 0) {
			this.quantidade = quantidade + i;
			return ResponseEntity.ok("");
		}
		return (ResponseEntity<String>) ResponseEntity.internalServerError();

	}

	public ResponseEntity<String> atualizar(DadosAtualizacaoProduto dados) {
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
		if (dados.codigoProduto() != null) {
			this.codigoProduto = dados.codigoProduto();
		}
		
		return ResponseEntity.ok("");

	}

}