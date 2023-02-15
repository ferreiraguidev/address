package com.example.address.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class PersonRespBody {
    private Long id;
    private String cpf;
    private String name;
    private String rg;
    private String email;

}
