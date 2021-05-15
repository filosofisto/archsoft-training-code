package com.archsoft.mongodb.converter;

import com.archsoft.mongodb.model.Product;
import com.archsoft.mongodb.to.ProductTO;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter extends Converter<Product, ProductTO> {
}
