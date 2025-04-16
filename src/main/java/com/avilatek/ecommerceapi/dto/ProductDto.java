package com.avilatek.ecommerceapi.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProductDto {
    private UUID id;
    private String name;
    private BigDecimal price;
    private int stock;
    private String description;
}