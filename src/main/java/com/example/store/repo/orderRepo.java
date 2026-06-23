package com.example.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.entity.order;

public interface orderRepo extends JpaRepository <order, Long>{
    
}
