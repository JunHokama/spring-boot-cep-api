package com.example.external.api.springbootexternalapiconsumingexample.cep.inquiry;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("cep-inquiry")
public class CepInquiry {

    @GetMapping("{cep}")
    public ResponseEntity<Object> cepInquiry(@PathVariable("cep") String cep) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CepResultDto> resp = restTemplate.getForEntity(
                String.format("https://viacep.com.br/ws/%s/json", cep),
                CepResultDto.class
        );
        if (resp.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CEP not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(resp.getBody());
    }}

