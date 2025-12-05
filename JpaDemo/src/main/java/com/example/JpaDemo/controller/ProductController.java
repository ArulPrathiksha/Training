package com.example.JpaDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JpaDemo.entity.Product;
import com.example.JpaDemo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getProducts(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id){
        return productService.getById(id);
    }

    @PostMapping
    public String addProduct(@RequestBody Product product){
        productService.create(product);
        return "PRODUCT ADDED SUCCESSFULLY";
    }

    @PutMapping
    public String updateProduct(@RequestBody Product product){
        productService.update(product);
        return "PRODUCT UPDATED SUCCESSFULLY";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Integer id){
        productService.delete(id);
        return "DELETED SUCCESSFULLY";
    }

}
