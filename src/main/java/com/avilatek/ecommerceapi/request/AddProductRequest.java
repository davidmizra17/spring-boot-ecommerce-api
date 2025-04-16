package com.avilatek.ecommerceapi.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddProductRequest {
    private Long id;
    private String name;
    private BigDecimal price;
    private int stock;
    private String description;
}