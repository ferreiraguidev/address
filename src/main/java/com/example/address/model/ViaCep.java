package com.example.address.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViaCep {
    private String cep;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String logradouro;
    private String ibge;
}
