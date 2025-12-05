package com.example.resttemplate;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class RestTemplateController {
    private RestTemplateService restTemplateService;

    public RestTemplateController(RestTemplateService restTemplateService){
        this.restTemplateService = restTemplateService;
    }
   
    @GetMapping("/get")
    public List<Product> getAllProducts(){
        return restTemplateService.getProducts();
    }
    
    
}
