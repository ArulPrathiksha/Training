package com.example.JpaDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JpaDemo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product , Integer>{
    
}
