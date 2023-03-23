package com.example.address.gateway;


import com.example.address.client.AddressRepository;
import com.example.address.client.PersonClient;
import com.example.address.dto.AddressPostReqBody;
import com.example.address.handler.PessoaInexistenteException;
import com.example.address.model.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AddressGateway {

    private final AddressRepository addressRepository;
    private final CepGateway cepGateway;

    private final PersonClient personClient;

    public Address save(final AddressPostReqBody addressPostReqBody) throws Exception {
        try {
            var viaCep = cepGateway.getCep(addressPostReqBody.getCep());
            personClient.findByPersonId(addressPostReqBody.getPersonId());
            if (viaCep.getCep() != null) {
                final var address = Address.builder()
                        .cep(addressPostReqBody.getCep())
                        .city(viaCep.getLocalidade())
                        .street(viaCep.getLogradouro())
                        .uf(viaCep.getUf())
                        .ibge(viaCep.getIbge())
                        .bairro(viaCep.getBairro())
                        .personId(addressPostReqBody.getPersonId())
                        .build();
                return addressRepository.save(address);
            }

        } catch (Exception ex) {
            throw new PessoaInexistenteException("Impossível salvar endereço sem relaciona-lo com uma pessoa!");
        }
        return null;
    }

    public List<Address> listAllAddresses(final Long id) {
        return addressRepository.findByPersonId(id);
    }
}
