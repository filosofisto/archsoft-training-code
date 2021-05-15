package com.archsoft.to;

import lombok.Data;

@Data
public class AddProductRequestTO {

    private String orderId;

    private String productId;

    private Integer quantity;
}
