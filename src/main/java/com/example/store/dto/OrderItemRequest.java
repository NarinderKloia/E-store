package com.example.store.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemRequest {

    @NotNull(message = "Product id is required")
    private Long productid;

    @NotNull(message = "quantity is required")
    @Min(value = 0, message = "quatity must be At least one")
    private Integer quatity;

}
