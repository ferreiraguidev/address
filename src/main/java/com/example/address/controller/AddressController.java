package com.example.address.controller;


import com.example.address.gateway.AddressGateway;
import com.example.address.gateway.CepGateway;
import com.example.address.model.Address;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class AddressController {
    private final AddressGateway addressGateway;
    private final CepGateway cepGateway;

    public AddressController(AddressGateway addressGateway, CepGateway cepGateway) {
        this.addressGateway = addressGateway;
        this.cepGateway = cepGateway;
    }

    @GetMapping("{id}")
    @ResponseStatus(OK)
    public List<Address> listAllAddressesById(@PathVariable Long id) {
        return addressGateway.listAllAddresses(id);
    }

    @ResponseStatus(CREATED)
    @PostMapping("address/save")
    public Address save(@RequestBody Address addressPostRequestBody) throws Exception {
        return addressGateway.save(AddressMapper.addressToModel(addressPostRequestBody));
    }
}
