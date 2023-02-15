package com.example.address.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class AddressPostReqBody {
    private String cep;
    private Long personId;
}
