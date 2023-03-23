package com.example.address.handler;

public class PessoaInexistenteException extends RuntimeException{

    public PessoaInexistenteException(String message) {
        super(message);
    }
}
