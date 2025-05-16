package com.example.sistema_estoque.exception;

public class InsufficientStockException extends RuntimeException{
    public InsufficientStockException(String mensagem){
        super(mensagem);
    }
}
