package com.archsoft.to;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrderItemTO implements Serializable {

    private String productId;
    private BigDecimal price;
    private Integer quantity;
    private Integer discount;

    //------- Additional info about Product
    private String name;
    private String description;
    private String category;
}
