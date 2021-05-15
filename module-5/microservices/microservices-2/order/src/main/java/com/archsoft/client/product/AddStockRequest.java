package com.archsoft.client.product;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class AddStockRequest implements Serializable {

    private String productId;

    private Integer quantity;
}
