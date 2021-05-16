package com.archsoft.util.converter;

import com.archsoft.model.product.Product;
import com.archsoft.to.product.ProductTO;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter extends Converter<Product, ProductTO> {
}
