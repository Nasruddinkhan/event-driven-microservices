package com.mypractice.event.driven.microservice.handler;

import com.mypractice.event.driven.microservice.entity.ProductEntity;
import com.mypractice.event.driven.microservice.events.ProductCreatedEvent;
import com.mypractice.event.driven.microservice.repository.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public record ProductEventHandler(ProductRepository productRepository) {

    @EventHandler
    public void on(ProductCreatedEvent createdEvent) {
//        productRepository.findById(createdEvent.getProductId()).ifPresent((e) -> {
//            throw new RuntimeException("record already present");
//        });
        final var productEntity = new ProductEntity();
        BeanUtils.copyProperties(createdEvent, productEntity);
        productRepository.save(productEntity);
    }
}
