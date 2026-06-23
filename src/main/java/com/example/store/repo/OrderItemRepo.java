package com.example.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.entity.OrderItems;

public interface OrderItemRepo extends JpaRepository <OrderItems, Long> {
    
}
