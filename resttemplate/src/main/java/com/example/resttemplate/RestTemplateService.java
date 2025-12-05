package com.example.resttemplate;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateService {
    
    private final RestTemplate restTemplate;

    public RestTemplateService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Product> getProducts(){
        String url = "http://localhost:8080/products";
        Product[] products = restTemplate.getForObject(url, Product[].class);
        return Arrays.asList(products);
    }

}
