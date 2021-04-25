package com.archsoft.amazon.service;

import com.archsoft.amazon.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductService {

    public Product findByCode(String code) {
        return Product.builder()
                .code(code)
                .description("Book")
                .price(new BigDecimal(150d))
                .build();
    }
}
