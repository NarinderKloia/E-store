package com.example.store.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.entity.Product;
import com.example.store.services.ProductServices;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private ProductServices productservices;

    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product) {
        return productservices.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product product) {
        return productservices.updateProduct(id, product);
    }

    @GetMapping
    public List<Product> getProduct() {
        return productservices.getProduct();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productservices.getProductById(id);

    }

    @DeleteMapping("{id}")
    public void deleteProduct(@Valid Long id) {
        productservices.deleteProduct(id);
    }

}
