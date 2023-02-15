package com.example.address.controller;

import com.example.address.dto.AddressPostReqBody;
import com.example.address.model.Address;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddressMapper {


    public static AddressPostReqBody addressToModel(Address respBody) {
        return AddressPostReqBody.builder()
                .cep(respBody.getCep())
                .personId(respBody.getPersonId())
                .build();

    }
}
