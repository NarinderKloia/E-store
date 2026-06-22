package com.example.store.entity;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false )
    @NotBlank(message = "product name must be required")
    private String name;

    private String description;

    private String category;

    @Min(value = 0,
        message = "Price Must be greater then zero"
    )
    @NotBlank(message = "price is required")
    @Column(nullable = false)
    private BigDecimal price;

    @NotBlank(message = "stock quantity is required")
    @Min(value = 0,
        message = "stock cannot less then zero"
    )
    @Column(name ="stock_quantity",nullable = false)
    private Integer stock;
}
