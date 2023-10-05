package com.kondo.externalApis.controllers;

import com.kondo.externalApis.entities.Correios;
import com.kondo.externalApis.services.CorreiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CorreiosController {

    @Autowired
    private CorreiosService correiosService;

    @GetMapping("/endereco/{cep}")
    public ResponseEntity<Correios> getEnderecoByCep(@PathVariable String cep) {
        Correios endereco = correiosService.getEnderecoByCep(cep);

        if (endereco != null) {
            return ResponseEntity.ok(endereco);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

