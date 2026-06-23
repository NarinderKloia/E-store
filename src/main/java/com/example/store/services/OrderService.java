package com.example.store.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.example.store.dto.OrderItemRequest;
import com.example.store.dto.OrderRequest;
import com.example.store.entity.Product;
import com.example.store.entity.order;
import com.example.store.repo.ProductRepo;
import com.example.store.repo.orderRepo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
    BigDecimal totalPrice = BigDecimal.ZERO;
    private orderRepo orderrepo;
    private ProductRepo productRepo;

    @Transactional
    public order creatOrder(OrderRequest orderRequest) {
        order order = new order();
        order.setCustomerName(orderRequest.getCustomerName());
        order.setCustomerEmail(orderRequest.getCustomerEmail());
        order.setStatus("CONFIRMED");

        for (OrderItemRequest itemRequest : orderRequest.getItems()) {
            Product product = productRepo.findById(itemRequest.getProductid()).orElseThrow(
                    () -> new RuntimeException("Product not found with Id"));
        }

        // BigDecimal priceOfItem = product.

        // totalPrice = totalPrice.add(priceOfItem);

        return order;
    }
}
