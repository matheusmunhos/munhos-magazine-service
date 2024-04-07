package com.munhos.magazine.service.domain.venda.exception;

public class ProdutoForaDeEstoqueException extends RuntimeException{

    public ProdutoForaDeEstoqueException(){
        super("Produto fora de estoque.");
    }

    public ProdutoForaDeEstoqueException(String message){
        super(message);
    }
}
