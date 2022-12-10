package com.mypractice.event.driven.microservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponseDto {
    private String productId;
    private String title;
    private BigDecimal price;
    private Integer quantity;
}
