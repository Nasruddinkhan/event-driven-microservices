package com.mypractice.event.driven.microservice.repository;

import com.mypractice.event.driven.microservice.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
    ProductEntity findByProductIdOrTitle(final String productId, final String title);
}
