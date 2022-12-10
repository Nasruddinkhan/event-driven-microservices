package com.mypractice.event.driven.microservice.controller;

import com.mypractice.event.driven.microservice.commonds.CreateProductCommand;
import com.mypractice.event.driven.microservice.dto.CreateProductRequestDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final Environment envoirment;
    private final CommandGateway commandGateway;
    @Autowired
    public ProductController(Environment envoirment, CommandGateway commandGateway) {
        super();
        this.envoirment = envoirment;
        this.commandGateway = commandGateway;
    }



    @PostMapping
    public String createProduct(@RequestBody CreateProductRequestDto productRequestDto) {
        var createProductCommand =
                CreateProductCommand.builder()
                                    .productId(UUID.randomUUID().toString())
                                    .price(productRequestDto.getPrice())
                                    .quantity(productRequestDto.getQuantity())
                                    .title(productRequestDto.getTitle()).build();
        return commandGateway.sendAndWait(createProductCommand);
    }
}
