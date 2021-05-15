package com.archsoft.to;

import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
public class ProductTO {

    private String id;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;
    private Map<String, String> attributes = new HashMap<String, String>();
    private Integer port;
}
