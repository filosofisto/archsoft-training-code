package com.archsoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StockAction extends AbstractDocument {

    private String productId;

    private Integer quantity;
}
