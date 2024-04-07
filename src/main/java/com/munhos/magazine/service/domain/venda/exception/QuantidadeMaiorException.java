package com.munhos.magazine.service.domain.venda.exception;

public class QuantidadeMaiorException extends RuntimeException{

    public QuantidadeMaiorException(){
        super("Quantidade maior do que a disponivel no estoque.");
    }

    public QuantidadeMaiorException(String message){
        super(message);
    }

}
