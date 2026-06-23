package com.example.store.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.dto.OrderRequest;
import com.example.store.services.OrderService;
import com.example.store.entity.order;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    
    private final OrderService orderService;

    @PostMapping
    public order createOrder(@Valid @RequestBody OrderRequest orderRequest){
        return orderService.creatOrder(orderRequest);
        
    }
}
