package com.example.JpaDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JpaDemo.entity.Product;
import com.example.JpaDemo.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    public void create(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
