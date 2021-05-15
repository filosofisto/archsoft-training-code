package com.archsoft.to;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddStockRequestTO implements Serializable {

    private String productId;

    private Integer quantity;
}
