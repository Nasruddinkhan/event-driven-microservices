package com.mypractice.event.driven.microservice.controller;

import com.mypractice.event.driven.microservice.commonds.CreateProductCommand;
import com.mypractice.event.driven.microservice.dto.CreateProductRequestDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public record ProductController(Environment envoirment,  CommandGateway commandGateway) {

    @PostMapping
    public String createProduct(@RequestBody @Valid CreateProductRequestDto productRequestDto) {
        return commandGateway.sendAndWait(CreateProductCommand.builder()
                .productId(UUID.randomUUID().toString())
                .price(productRequestDto.getPrice())
                .quantity(productRequestDto.getQuantity())
                .title(productRequestDto.getTitle()).build());
    }
}
