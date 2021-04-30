package com.archsoft.mongodb.converter;

import com.archsoft.mongodb.model.Product;
import com.archsoft.mongodb.to.ProductTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Component
public class ProductConverter extends Converter<Product, ProductTO> {

    public Product fromMapToEntity(Map<String, Object> map) {
        Product product = new Product();

        product.setId(Optional.ofNullable(map.get("id"))
                .map(Objects::toString)
                .orElse(null));
        product.setName(Optional.ofNullable(map.get("description"))
                .map(Objects::toString)
                .orElse(null));
        product.setDescription(Optional.ofNullable(map.get("description"))
                .map(Objects::toString)
                .orElse(null));
        product.setPrice(new BigDecimal(Optional.ofNullable(map.get("price"))
                .map(x -> (Double) x)
                .orElse(0d)));
        product.setCategory(Optional.ofNullable(map.get("category"))
                .map(Objects::toString)
                .orElse(null));
        return product;
    }
}
