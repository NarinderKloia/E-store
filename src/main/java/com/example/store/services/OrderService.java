package com.example.store.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.example.store.dto.OrderItemRequest;
import com.example.store.dto.OrderRequest;
import com.example.store.entity.OrderItems;
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
    private final orderRepo orderrepo;
    private final ProductRepo productRepo;

    @Transactional
    public order creatOrder(OrderRequest orderRequest) {
        order order = new order();
        List<OrderItems> orderItems = new ArrayList<>();

        order.setCustomerName(orderRequest.getCustomerName());
        order.setCustomerEmail(orderRequest.getCustomerEmail());
        order.setStatus("CONFIRMED");

        for (OrderItemRequest itemRequest : orderRequest.getItems()) {
            Product product = productRepo
                    .findById(itemRequest.getProductid()).orElseThrow(
                            () -> new RuntimeException("Product not found with Id"));

            if (product.getStock() < itemRequest.getQuantity()) {
                throw new RuntimeException("not enough stock");
            }

            BigDecimal priceOfItem = product.getPrice()
                    .multiply(BigDecimal.valueOf(itemRequest.getQuantity()));

            totalPrice = totalPrice.add(priceOfItem);

            product.setStock(
                    product.getStock() - itemRequest.getQuantity());

            productRepo.save(product);

            OrderItems orderItem = OrderItems.builder()
                    .order(order)
                    .product(product)
                    .quantity(itemRequest.getQuantity())
                    .priceAtPurchase(product.getPrice())
                    .build();

            orderItems.add(orderItem);
        }
        order.setTotalPrice(totalPrice);
        order.setOrderitems(orderItems);

        return orderrepo.save(order);
    }
}
