package com.archsoft.amazon.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Product {

    private String code;
    private String description;
    private BigDecimal price;
}
