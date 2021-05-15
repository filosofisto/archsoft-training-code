package com.archsoft.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrderItem implements Serializable {

    private String productId;

    private BigDecimal price;

    private Integer quantity;

    private Integer discount;
}
