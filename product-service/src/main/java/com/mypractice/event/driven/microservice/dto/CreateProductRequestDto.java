package com.mypractice.event.driven.microservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateProductRequestDto {

    @NotEmpty(message = "title cannot be null or empty")
    private String title;

    @NotNull(message = "price cannot be null or empty")
    @Min(value = 1, message = "price cannot be lower than 1")
    private BigDecimal price;

    @NotNull(message = "quantity cannot be null or empty")
    @Min(value = 1, message = "price cannot be lower than 1")
    @Max(value = 5, message = "quantity cannot be larger than 5")
    private Integer quantity;

}
