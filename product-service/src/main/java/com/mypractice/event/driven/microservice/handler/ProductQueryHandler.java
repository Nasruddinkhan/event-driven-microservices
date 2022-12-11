package com.mypractice.event.driven.microservice.handler;

import com.mypractice.event.driven.microservice.dto.ProductResponseDto;
import com.mypractice.event.driven.microservice.repository.ProductRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public record ProductQueryHandler(ProductRepository productRepository) {
    

    @QueryHandler
    public List<ProductResponseDto> findProducts() {
        return productRepository.findAll().stream().map(e -> {
            var productsRes = new ProductResponseDto();
            BeanUtils.copyProperties(e, productsRes);
            return productsRes;
        }).collect(Collectors.toList());
    }

}
