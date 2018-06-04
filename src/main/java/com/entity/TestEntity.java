package com.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TestEntity {

    private String name;

    private BigDecimal price;

    private BigDecimal product_price;

}
