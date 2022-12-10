package com.mypractice.event.driven.microservice.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Table(name = "product")
@Entity
public class ProductEntity implements Serializable {
    public static final long serialVersionUID = 43L;
    @Id
    @Column(name = "productId", unique = true)
    private String productId;
    @Column(name = "title", unique = true, length = 30)
    private String title;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "quantity")
    private Integer quantity;
}
