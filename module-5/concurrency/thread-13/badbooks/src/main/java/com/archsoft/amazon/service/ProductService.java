package com.archsoft.amazon.service;

import com.archsoft.amazon.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
public class ProductService {

    public Product findByCode(String code) {
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return Product.builder()
                .code(code)
                .description("Book")
                .price(new BigDecimal(82.50d))
                .build();
    }
}
