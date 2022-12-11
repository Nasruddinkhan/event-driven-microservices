package com.mypractice.event.driven.microservice.controller;

import com.mypractice.event.driven.microservice.dto.ProductResponseDto;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public record ProductQueryController(QueryGateway queryGateway) {


    @GetMapping
    public List<ProductResponseDto> getProducts() {
        final var products = queryGateway
                .query(new Object(), ResponseTypes.multipleInstancesOf(ProductResponseDto.class)).join();
        return products;
    }


}
