package com.najwa.Product_Service.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {
    private Long productId; // Product ID
    private String name;    // Name of the product
    private double weight;  // Weight of the product
}
