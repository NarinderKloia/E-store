package com.example.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
    
    
}