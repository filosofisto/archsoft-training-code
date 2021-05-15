package com.archsoft.client.product;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductAvailabilityRequest {

    private String productId;

    private Integer quantity;
}
