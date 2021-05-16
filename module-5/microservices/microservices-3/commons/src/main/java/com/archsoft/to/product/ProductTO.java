package com.archsoft.to.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductTO {

    private String id;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;
    private Map<String, String> attributes = new HashMap<String, String>();

    private String originalId;
}
