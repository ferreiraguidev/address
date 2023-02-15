package com.example.address.client;


import com.example.address.dto.PersonRespBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(url = "localhost:8081", name = "personClient")
public interface PersonClient {

    @GetMapping("person/find/{id}")
    PersonRespBody findByPersonId(@PathVariable Long id);
}
