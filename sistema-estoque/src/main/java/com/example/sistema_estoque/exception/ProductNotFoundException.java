package com.example.sistema_estoque.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String mensagem){
        super(mensagem);
    }
}
