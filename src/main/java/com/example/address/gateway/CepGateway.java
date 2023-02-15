package com.example.address.gateway;


import com.example.address.model.ViaCep;
import com.example.address.client.ViaCepClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CepGateway {

    private final ViaCepClient viaCepClient;

    public ViaCep getCep(String cep) {
        return viaCepClient.findByAddress(cep);
    }
}
