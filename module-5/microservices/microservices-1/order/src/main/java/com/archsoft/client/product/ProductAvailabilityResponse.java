package com.archsoft.client.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductAvailabilityResponse {

    private BigDecimal price;

    private boolean available;
}
