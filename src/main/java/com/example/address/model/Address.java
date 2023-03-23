package com.example.address.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String cep;
    private String street;
    private String city;

    private String uf;
    private String ibge;
    private String bairro;

    @NotNull(message = "Pessoa é obrigatória para salvar um endereço")
    private Long personId;

}
