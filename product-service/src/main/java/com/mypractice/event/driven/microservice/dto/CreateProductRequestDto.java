package com.mypractice.event.driven.microservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateProductRequestDto {

    private String title;
    private BigDecimal price;
    private Integer quantity;

}
