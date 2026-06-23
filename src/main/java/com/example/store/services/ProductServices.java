package com.example.store.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.store.entity.Product;
import com.example.store.repo.ProductRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServices {

    private final ProductRepo productrepo;

    public Product createProduct(Product product) {
        return productrepo.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productrepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id" + id));

        existingProduct.setName(product.getName());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStock(product.getStock());

        return productrepo.save(existingProduct);

    }

    public List<Product> getProduct() {

        return productrepo.findAll();
    }

    public Product getProductById(Long id) {

        return productrepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found by the Id " + id));

    }

    public String deleteProduct(Long id) {

    if(id == null){
        return "Product ID cannot be null";
    }

    productrepo.deleteById(id);
    return "Product Deleted Successfully";
}
}
