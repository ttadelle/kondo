package com.kondo.externalApis.services;

import com.kondo.externalApis.entities.Correios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CorreiosService {

    @Autowired
    private RestTemplate restTemplate;

    public Correios getEnderecoByCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        ResponseEntity<Correios> response = restTemplate.getForEntity(url, Correios.class);
        return response.getBody();
    }
}
